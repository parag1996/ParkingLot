package io.assignment.parkinglot.daoimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import io.assignment.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parkinglot.dao.ParkingLotDao;
import io.assignment.parkinglot.models.Car;
import io.assignment.parkinglot.models.ParkingSlot;
import io.assignment.parkinglot.models.Ticket;
import io.assignment.parkinglot.models.Vehicle;
import io.assignment.parkinglot.util.Constants;

/**
 * This class implements methods in ParkingLotDao interface
 *
 */
public class ParkingLotDaoImpl implements ParkingLotDao{

	private final ParkingCapacityDao parkingCapacityDao;
	private final Map<Vehicle , Ticket> vehicleOccupiedSlots = new HashMap<>();
	
	public ParkingLotDaoImpl(ParkingCapacityDao parkingCapacityDao)
	{
		this.parkingCapacityDao=parkingCapacityDao;
	}
	
	@Override
	public void park(String regNumber)
	{
		ParkingSlot parkingSlot = parkingCapacityDao.getAvailableSlot();
		if(parkingSlot!=null)
		{
			Vehicle car = new Car(regNumber);
			Ticket ticket = new Ticket(car,parkingSlot);
			vehicleOccupiedSlots.put(car, ticket);
			System.out.println(Constants.ALLOCATED_SLOT_NUMBER+parkingSlot.getNumber());
		}
	}
	
	@Override
	public Ticket unPark(Vehicle car)
	{
		
		Ticket ticket = vehicleOccupiedSlots.remove(car);
		if(ticket==null)
		{
			System.out.println(Constants.REGISTRATION_NUMBER+car.getRegNumber()+Constants.NOT_FOUND);
		}
		return ticket;
		
	}
	
	@Override
	public Stream<Ticket> getCurrentStatus()
	{
		return vehicleOccupiedSlots.values().stream();
	}
}
