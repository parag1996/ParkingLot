package io.assignment.parkinglot.models;

public class ParkingSlot implements Comparable<ParkingSlot> {

	private int number;

	public ParkingSlot(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ParkingSlot [number=" + number + "]";
	}

	@Override
	public int compareTo(ParkingSlot o) {

		return this.getNumber() - o.getNumber();
	}

}
