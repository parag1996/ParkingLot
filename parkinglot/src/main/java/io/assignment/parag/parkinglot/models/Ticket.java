package io.assignment.parag.parkinglot.models;

import java.time.Instant;
import java.util.UUID;

public class Ticket {

	private String id;
	private Vehicle vehicle;
	private ParkingSlot parkingSlot;
	private Instant entryTime;
	private int duration;
	private double fare;

	public Ticket(Vehicle vehicle, ParkingSlot parkingSlot) {
		this.vehicle = vehicle;
		this.parkingSlot = parkingSlot;
		this.entryTime = Instant.now();
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public Instant getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Instant entryTime) {
		this.entryTime = entryTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
