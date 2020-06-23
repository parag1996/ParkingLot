package io.assignment.parag.parkinglot.service;

import io.assignment.parag.parkinglot.exception.ParkingException;
import io.assignment.parag.parkinglot.models.Ticket;

/**
 * This is service class interface of parkinglot
 *
 */
public interface ParkingLotService {

	void createNewParkingSlot(int capacity) throws ParkingException;

	void parkCar(String regNumber) throws ParkingException;

	Ticket unParkCar(String regNumber, int duration) throws ParkingException;

	void getStatus() throws ParkingException;
}
