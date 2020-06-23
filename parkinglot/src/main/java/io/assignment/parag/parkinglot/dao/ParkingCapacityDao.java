package io.assignment.parag.parkinglot.dao;

import io.assignment.parag.parkinglot.models.ParkingSlot;

/**
 * This interface different methods declaration related to parking Slots.
 *
 */
public interface ParkingCapacityDao {

	void add(ParkingSlot parkingSlot);
	
	ParkingSlot getAvailableSlot();
	
	int getCurrentAvailableSlots();
	
	int createSlots(int num);
}
