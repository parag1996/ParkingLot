package io.assignment.parag.parkinglot.daoimpl;

import java.util.HashMap;
import java.util.Map;

import io.assignment.parag.parkinglot.dao.ParkingTicketDao;
import io.assignment.parag.parkinglot.models.Ticket;
import io.assignment.parag.parkinglot.models.Vehicle;

/**
 * This class implements methods in ParkingTicketDao interface
 *
 */
public class ParkingTicketDaoImpl implements ParkingTicketDao {

	private final Map<Vehicle, Ticket> carHistory;

	public ParkingTicketDaoImpl() {
		carHistory = new HashMap<>();
	}

	@Override
	public Ticket generateParkingTicket(Vehicle car, Ticket ticket) {
		double fare = 0d;
		int hours = ticket.getDuration();
		if (hours >= 2) {
			fare = 10d;
			hours -= 2;
		}
		fare += hours * 10d;
		ticket.setFare(fare);
		carHistory.put(car, ticket);

		return ticket;
	}
}
