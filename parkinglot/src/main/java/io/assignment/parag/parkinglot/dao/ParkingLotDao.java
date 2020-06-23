package io.assignment.parag.parkinglot.dao;

import java.util.Collection;
import io.assignment.parag.parkinglot.models.Ticket;
import io.assignment.parag.parkinglot.models.Vehicle;

/**
 * This interface defines declaration parking strategies methods
 *
 */
public interface ParkingLotDao {

	void park(String regNumber);

	Ticket unPark(Vehicle car);

	Collection<Ticket> getCurrentStatus();

	Ticket getVehicleOccupiedSlots(Vehicle car);
}
