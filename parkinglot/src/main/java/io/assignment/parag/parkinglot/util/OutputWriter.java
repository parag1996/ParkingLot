package io.assignment.parag.parkinglot.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

import io.assignment.parag.parkinglot.models.ParkingSlot;
import io.assignment.parag.parkinglot.models.Ticket;

public class OutputWriter {

	public void writeParkingLotCreated(int capacity)
	{
		System.out.println(Constants.CREATED_PARKING_LOT_WITH+capacity+Constants.SLOTS);
	}
	
	public void writeParkingOccupied(ParkingSlot parkingSlot)
	{
		System.out.println(Constants.ALLOCATED_SLOT_NUMBER+parkingSlot.getNumber());
	}
	
	public void writeParkedVehicleNotFound(String regNumber)
	{
		System.out.println(Constants.REGISTRATION_NUMBER+regNumber+Constants.NOT_FOUND);
	}
	
	public void writeVehicleLeftParking(Ticket ticket)
	{
		System.out.println(Constants.REGISTRATION_NUMBER + ticket.getVehicle().getRegNumber()
				+ Constants.IS_FREE_WITH_CHARGE + (int)ticket.getFare());
	}
	
	public void writeStatus(Collection<Ticket> allocatedVehicles)
	{
		System.out.println(Constants.SLOT_NO_REGISTRATION_NO);
		allocatedVehicles.stream().sorted(Comparator.comparingInt(num -> num.getParkingSlot().getNumber()))
				.forEach(ticket -> System.out.println(
						ticket.getParkingSlot().getNumber() + Constants.SPACE + ticket.getVehicle().getRegNumber()));
	}
}
