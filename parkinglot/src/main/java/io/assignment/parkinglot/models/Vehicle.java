package io.assignment.parkinglot.models;

import java.util.Objects;

public abstract class Vehicle {

	private String regNumber;
	private String color;

	public Vehicle(String regNumber) {
		this.regNumber = regNumber;
	}

	public Vehicle(String regNumber, String color) {
		this.regNumber = regNumber;
		this.color = color;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Vehicle))
			return false;
		Vehicle vehicle = (Vehicle) other;
		return getRegNumber().equals(vehicle.getRegNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRegNumber());
	}
}
