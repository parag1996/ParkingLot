package io.assignment.parag.parkinglot.daoimpl;

import java.util.TreeSet;

import io.assignment.parag.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parag.parkinglot.models.ParkingSlot;
import io.assignment.parag.parkinglot.util.Constants;

/**
 * This class implements methods in ParkingCapacityDao interface
 *
 */
public class ParkingCapacityDaoImpl implements ParkingCapacityDao {

	private final TreeSet<ParkingSlot> parkingSlots;

	public ParkingCapacityDaoImpl() {
		this.parkingSlots = new TreeSet<ParkingSlot>();
	}

	@Override
	public void add(ParkingSlot parkingSlot) {
		parkingSlots.add(parkingSlot);

	}

	@Override
	public ParkingSlot getAvailableSlot() {
		if (parkingSlots.isEmpty())
			System.out.println(Constants.PARKING_IS_FULL);

		return parkingSlots.pollFirst();
	}

	@Override
	public int getCurrentAvailableSlots() {

		return parkingSlots.size();
	}

	@Override
	public int createSlots(int num) {
		int size;
		if (parkingSlots != null) {
			for (int i = 1; i <= num; i++) {
				parkingSlots.add(new ParkingSlot(i));
			}
		} else {
			System.out.println(Constants.PARKING_IS_ALREADY_CREATED);
		}
		size = parkingSlots.size() == num ?parkingSlots.size():null;
		return size;
	}

}
