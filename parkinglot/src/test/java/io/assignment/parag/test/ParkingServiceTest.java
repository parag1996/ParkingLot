package io.assignment.parag.test;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.stream.Stream;

import org.junit.Test;

import io.assignment.parag.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parag.parkinglot.dao.ParkingLotDao;
import io.assignment.parag.parkinglot.dao.ParkingTicketDao;
import io.assignment.parag.parkinglot.daoimpl.ParkingCapacityDaoImpl;
import io.assignment.parag.parkinglot.daoimpl.ParkingLotDaoImpl;
import io.assignment.parag.parkinglot.daoimpl.ParkingTicketDaoImpl;
import io.assignment.parag.parkinglot.exception.ParkingException;
import io.assignment.parag.parkinglot.models.Car;
import io.assignment.parag.parkinglot.models.Ticket;
import io.assignment.parag.parkinglot.service.ParkingLotService;
import io.assignment.parag.parkinglot.serviceimpl.ParkingLotServiceImpl;

public class ParkingServiceTest {

	private ParkingCapacityDao parkingCapacityDao;
	private ParkingLotDao parkingLotDao;
	private ParkingTicketDao parkingTicketDao;
	private ParkingLotService parkingLotService;

	public ParkingServiceTest() {
		this.parkingCapacityDao = new ParkingCapacityDaoImpl();
		this.parkingLotDao = new ParkingLotDaoImpl(parkingCapacityDao);
		this.parkingTicketDao = new ParkingTicketDaoImpl();
		this.parkingLotService = new ParkingLotServiceImpl(parkingCapacityDao, parkingTicketDao, parkingLotDao);
	}

	@Test
	public void test() {
		System.out.println("Junit is working");
	}

	@Test
	public void testForParkingLotCreation() {
		int size = 4;

		assertEquals(size,parkingCapacityDao.createSlots(size));
	}
	
	@Test
	public void testForParkVehicle() throws ParkingException {

		int size = 2;
		parkingCapacityDao.createSlots(size);
	     parkingLotDao.park("MH-32-XYZ");
	     Ticket parkingTicket = parkingLotDao.getVehicleOccupiedSlots(new Car("MH-32-XYZ"));
			 assertEquals(parkingTicket.getVehicle().getRegNumber(), "MH-32-XYZ"); 
		
	}
	
	@Test
	public void testForUnparkVehicle() throws ParkingException {

		int size = 2;
		parkingCapacityDao.createSlots(size);
		parkingLotDao.park("MH-32-XYZ");
		Ticket ticket = parkingLotService.unParkCar("MH-32-XYZ", 4);
		assertEquals(new Car("MH-32-XYZ"), ticket.getVehicle());
		
	}
	
	@Test
	public void testForStatus() throws ParkingException {

		int size = 2;
		parkingCapacityDao.createSlots(size);
		parkingLotDao.park("MH-32-XYZ");
		parkingLotDao.park("MH-22-ABC");
		parkingLotService.getStatus();
		Collection<Ticket> allocatedTickets = parkingLotDao.getCurrentStatus();
		assertEquals(allocatedTickets.size(), size);
		
	}

}
