package io.assignment.parkinglot.daoimpl;

import java.util.TreeSet;
import io.assignment.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parkinglot.models.ParkingSlot;
import io.assignment.parkinglot.util.Constants;

/**
 * This class implements methods in ParkingCapacityDao interface
 *
 */
public class ParkingCapacityDaoImpl implements ParkingCapacityDao {

	private final TreeSet<ParkingSlot> parkingSlots;

	public ParkingCapacityDaoImpl() {
		parkingSlots = new TreeSet<ParkingSlot>();
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
	public void createSlots(int num) {
		if (parkingSlots != null) {
			for (int i = 1; i <= num; i++) {
				parkingSlots.add(new ParkingSlot(i));
			}
		} else {
			System.out.println(Constants.PARKING_IS_ALREADY_CREATED);
		}
	}

}
