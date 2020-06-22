package io.assignment.parkinglot.service;

import io.assignment.parkinglot.exception.ParkingException;

/**
 * This is service class interface of parkinglot
 *
 */
public interface ParkingLotService {

	void createNewParkingSlot(int capacity) throws ParkingException;

	void parkCar(String regNumber) throws ParkingException;

	void unParkCar(String regNumber, int duration) throws ParkingException;

	void getStatus() throws ParkingException;
}
