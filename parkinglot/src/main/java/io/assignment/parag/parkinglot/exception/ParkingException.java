package io.assignment.parag.parkinglot.exception;

/**
 * This exception class for ParkingLot
 *
 */
public class ParkingException extends Exception {

	private static final long serialVersionUID = 505729348277952213L;

	public ParkingException(String message) {
		super(message);
	}

	public ParkingException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
