package io.assignment.parkinglot.dao;

import java.util.stream.Stream;
import io.assignment.parkinglot.models.Ticket;
import io.assignment.parkinglot.models.Vehicle;

/**
 * This interface defines declaration parking strategies methods
 *
 */
public interface ParkingLotDao {

	void park(String regNumber);

	Ticket unPark(Vehicle car);

	Stream<Ticket> getCurrentStatus();
}
