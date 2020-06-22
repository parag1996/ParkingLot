package io.assignment.parkinglot.processor;

import io.assignment.parkinglot.exception.ParkingException;
import io.assignment.parkinglot.service.ParkingLotService;
import io.assignment.parkinglot.util.Constants;

/**
 * This class process input parameters
 *
 */
public class InputProcessor {

	private ParkingLotService parkingLotService;

	public InputProcessor(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}

	public void processInput(String[] arguments) throws ParkingException {

		switch (arguments[0]) {

		case Constants.CREATE_PARKING_LOT:
			if (arguments.length <= 2) {
				parkingLotService.createNewParkingSlot(Integer.parseInt(arguments[1]));
			} else {
				throw new ParkingException(Constants.MISSING_ARGUMENT);
			}
			break;

		case Constants.PARK:
			if (arguments.length <= 2) {
				parkingLotService.parkCar(arguments[1]);
			} else {
				throw new ParkingException(Constants.MISSING_ARGUMENT);
			}
			break;

		case Constants.LEAVE:
			if (arguments.length <= 3) {
				parkingLotService.unParkCar(arguments[1], Integer.parseInt(arguments[2]));
			} else {
				throw new ParkingException(Constants.MISSING_ARGUMENT);
			}
			break;

		case Constants.STATUS:
			if (arguments.length <= 3) {
				parkingLotService.getStatus();
			} else {
				throw new ParkingException(Constants.MISSING_ARGUMENT);

			}
			break;

		default:
			throw new ParkingException(Constants.INVALID_ARGUMENT);
		}
	}
}
