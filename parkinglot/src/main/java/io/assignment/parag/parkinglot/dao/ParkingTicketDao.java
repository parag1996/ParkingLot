package io.assignment.parag.parkinglot.dao;

import io.assignment.parag.parkinglot.models.Ticket;
import io.assignment.parag.parkinglot.models.Vehicle;

/**
 * This interface declares ticket generation methods
 *
 */
public interface ParkingTicketDao {

	Ticket generateParkingTicket(Vehicle car, Ticket ticket);
}
