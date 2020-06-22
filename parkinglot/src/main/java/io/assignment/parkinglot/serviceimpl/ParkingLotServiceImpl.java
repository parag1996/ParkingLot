package io.assignment.parkinglot.serviceimpl;

import java.util.Comparator;
import java.util.stream.Stream;
import io.assignment.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parkinglot.dao.ParkingLotDao;
import io.assignment.parkinglot.dao.ParkingTicketDao;
import io.assignment.parkinglot.exception.ParkingException;
import io.assignment.parkinglot.models.Car;
import io.assignment.parkinglot.models.Ticket;
import io.assignment.parkinglot.models.Vehicle;
import io.assignment.parkinglot.service.ParkingLotService;
import io.assignment.parkinglot.util.Constants;

/**
 * This class implements methods in ParkingLotService interface
 *
 */
public class ParkingLotServiceImpl implements ParkingLotService {

	private ParkingCapacityDao parkingCapacityDao;
	private ParkingTicketDao parkingTicketDao;
	private ParkingLotDao parkingLotDao;

	public ParkingLotServiceImpl(ParkingCapacityDao parkingCapacityDao, ParkingTicketDao parkingTicketDao,
			ParkingLotDao parkingLotDao) {
		this.parkingCapacityDao = parkingCapacityDao;
		this.parkingTicketDao = parkingTicketDao;
		this.parkingLotDao = parkingLotDao;
	}

	public void createNewParkingSlot(int capacity) throws ParkingException {
		try {
			parkingCapacityDao.createSlots(capacity);
		} catch (Exception e) {
			throw new ParkingException(Constants.PROCESSING_ERROR, e);
		}
	}

	public void parkCar(String regNumber) {
		parkingLotDao.park(regNumber);
	}

	public void unParkCar(String regNumber, int duration) throws ParkingException {
		Vehicle car = new Car(regNumber);

		try {

			Ticket ticket = parkingLotDao.unPark(car);
			if (ticket != null) {
				ticket.setDuration(duration);
				Ticket fareTicket = parkingTicketDao.generateParkingTicket(car, ticket);

				System.out.println(Constants.REGISTRATION_NUMBER + fareTicket.getVehicle().getRegNumber()
						+ Constants.IS_FREE_WITH_CHARGE + fareTicket.getFare());

				parkingCapacityDao.add(ticket.getParkingSlot());
			}
		} catch (Exception e) {
			throw new ParkingException(Constants.PROCESSING_ERROR, e);

		}
	}

	public void getStatus() {
		Stream<Ticket> allocatedTickets = parkingLotDao.getCurrentStatus();
		System.out.println(Constants.SLOT_NO_REGISTRATION_NO);
		allocatedTickets.sorted(Comparator.comparingInt(num -> num.getParkingSlot().getNumber()))
				.forEach(ticket -> System.out.println(
						ticket.getParkingSlot().getNumber() + Constants.SPACE + ticket.getVehicle().getRegNumber()));

	}
}
