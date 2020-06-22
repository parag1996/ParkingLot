package io.assignment.parkinglot.dao;

import io.assignment.parkinglot.models.Ticket;
import io.assignment.parkinglot.models.Vehicle;

/**
 * This interface declares ticket generation methods
 *
 */
public interface ParkingTicketDao {

	Ticket generateParkingTicket(Vehicle car, Ticket ticket);
}
