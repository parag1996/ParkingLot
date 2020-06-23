package io.assignment.parag.parkinglot.serviceimpl;

import java.util.stream.Stream;

import io.assignment.parag.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parag.parkinglot.dao.ParkingLotDao;
import io.assignment.parag.parkinglot.dao.ParkingTicketDao;
import io.assignment.parag.parkinglot.exception.ParkingException;
import io.assignment.parag.parkinglot.models.Car;
import io.assignment.parag.parkinglot.models.Ticket;
import io.assignment.parag.parkinglot.models.Vehicle;
import io.assignment.parag.parkinglot.service.ParkingLotService;
import io.assignment.parag.parkinglot.util.Constants;
import io.assignment.parag.parkinglot.util.OutputWriter;

/**
 * This class implements methods in ParkingLotService interface
 *
 */
public class ParkingLotServiceImpl implements ParkingLotService {

	private ParkingCapacityDao parkingCapacityDao;
	private ParkingTicketDao parkingTicketDao;
	private ParkingLotDao parkingLotDao;
	private OutputWriter outputWriter;

	public ParkingLotServiceImpl(ParkingCapacityDao parkingCapacityDao, ParkingTicketDao parkingTicketDao,
			ParkingLotDao parkingLotDao) {
		this.parkingCapacityDao = parkingCapacityDao;
		this.parkingTicketDao = parkingTicketDao;
		this.parkingLotDao = parkingLotDao;
		this.outputWriter = new OutputWriter();
	}

	public void createNewParkingSlot(int capacity) throws ParkingException {
		try {
			int treeSize = parkingCapacityDao.createSlots(capacity);
			
			outputWriter.writeParkingLotCreated(treeSize);
			
		} catch (Exception e) {
			throw new ParkingException(Constants.PROCESSING_ERROR, e);
		}
	}

	public void parkCar(String regNumber) throws ParkingException {
		parkingLotDao.park(regNumber);
		
	}

	public Ticket unParkCar(String regNumber, int duration) throws ParkingException {
		Vehicle car = new Car(regNumber);
		Ticket ticket = null;
		try {

			ticket = parkingLotDao.unPark(car);
			if (ticket != null) {
				ticket.setDuration(duration);
				ticket = parkingTicketDao.generateParkingTicket(car, ticket);

				outputWriter.writeVehicleLeftParking(ticket);

				parkingCapacityDao.add(ticket.getParkingSlot());
			}
		} catch (Exception e) {
			throw new ParkingException(Constants.PROCESSING_ERROR, e);

		}
		return ticket;
	}

	public void getStatus() {
		outputWriter.writeStatus(parkingLotDao.getCurrentStatus());

	}
}
