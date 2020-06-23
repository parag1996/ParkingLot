package io.assignment.parag.parkinglot.daoimpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.assignment.parag.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parag.parkinglot.dao.ParkingLotDao;
import io.assignment.parag.parkinglot.models.Car;
import io.assignment.parag.parkinglot.models.ParkingSlot;
import io.assignment.parag.parkinglot.models.Ticket;
import io.assignment.parag.parkinglot.models.Vehicle;
import io.assignment.parag.parkinglot.util.OutputWriter;

/**
 * This class implements methods in ParkingLotDao interface
 *
 */
public class ParkingLotDaoImpl implements ParkingLotDao{

	private final ParkingCapacityDao parkingCapacityDao;
	private final Map<Vehicle , Ticket> vehicleOccupiedSlots = new HashMap<>();
	private OutputWriter outputWriter;
	
	public ParkingLotDaoImpl(ParkingCapacityDao parkingCapacityDao)
	{
		this.parkingCapacityDao=parkingCapacityDao;
		this.outputWriter = new OutputWriter();
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
			outputWriter.writeParkingOccupied(parkingSlot);
		}
		
	}
	
	@Override
	public Ticket getVehicleOccupiedSlots(Vehicle car) {
		return vehicleOccupiedSlots.get(car);
	}

	@Override
	public Ticket unPark(Vehicle car)
	{
		
		Ticket ticket = vehicleOccupiedSlots.remove(car);
		if(ticket==null)
		{
			outputWriter.writeParkedVehicleNotFound(car.getRegNumber());
		}
		return ticket;
		
	}
	
	@Override
	public Collection<Ticket> getCurrentStatus()
	{
		return vehicleOccupiedSlots.values();
	}
}
