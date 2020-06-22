package io.assignment.parkinglot.dao;

import io.assignment.parkinglot.models.ParkingSlot;

/**
 * This interface different methods declaration related to parking Slots.
 *
 */
public interface ParkingCapacityDao {

	void add(ParkingSlot parkingSlot);
	
	ParkingSlot getAvailableSlot();
	
	int getCurrentAvailableSlots();
	
	void createSlots(int num);
}
