package io.assignment.parag.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import io.assignment.parag.parkinglot.dao.ParkingCapacityDao;
import io.assignment.parag.parkinglot.dao.ParkingLotDao;
import io.assignment.parag.parkinglot.dao.ParkingTicketDao;
import io.assignment.parag.parkinglot.daoimpl.ParkingCapacityDaoImpl;
import io.assignment.parag.parkinglot.daoimpl.ParkingLotDaoImpl;
import io.assignment.parag.parkinglot.daoimpl.ParkingTicketDaoImpl;
import io.assignment.parag.parkinglot.exception.ParkingException;
import io.assignment.parag.parkinglot.processor.InputProcessor;
import io.assignment.parag.parkinglot.service.ParkingLotService;
import io.assignment.parag.parkinglot.serviceimpl.ParkingLotServiceImpl;
import io.assignment.parag.parkinglot.util.Constants;

/**
 * Main class of ParkingLot service
 *
 */
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParkingException {
		ParkingCapacityDao parkingCapacityDao = new ParkingCapacityDaoImpl();
		ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(parkingCapacityDao);
		ParkingTicketDao parkingTicketDao = new ParkingTicketDaoImpl();
		BufferedReader bufferReader = null;
		String input = null;

		ParkingLotService parkingLotService = new ParkingLotServiceImpl(parkingCapacityDao, parkingTicketDao,
				parkingLotDao);

		InputProcessor inputProcessor = new InputProcessor(parkingLotService);

		if (args.length == 0) {
			throw new ParkingException(Constants.NO_INPUT_FILE);
		} else {

			try {

				File inputFile = new File(args[0]);
				bufferReader = new BufferedReader(new FileReader(inputFile));

				while ((input = bufferReader.readLine()) != null) {
					input = input.trim();
					String[] inputArray = input.split(" ");

					inputProcessor.processInput(inputArray);
				}

			} catch (Exception e) {
				throw new ParkingException(Constants.PROCESSING_ERROR, e);
			}
		}

		/*
		 * try { parkingLotService.createNewParkingSlot(6);
		 * parkingLotService.parkCar("KA-01-HH-1234");
		 * parkingLotService.parkCar("KA-01-HH-9999");
		 * parkingLotService.parkCar("KA-01-BB-0001");
		 * parkingLotService.parkCar("KA-01-HH-7777");
		 * parkingLotService.parkCar("KA-01-HH-2701");
		 * parkingLotService.parkCar("KA-01-HH-3141");
		 * parkingLotService.unParkCar("KA-01-HH-3141", 4);
		 * parkingLotService.getStatus(); parkingLotService.parkCar("KA-01-P-333");
		 * parkingLotService.parkCar("DL-12-AA-9999");
		 * parkingLotService.unParkCar("KA-01-HH-1234", 4);
		 * parkingLotService.unParkCar("KA-01-BB-0001", 6);
		 * parkingLotService.unParkCar("DL-12-AA-9999", 2);
		 * parkingLotService.parkCar("KA-09-HH-0987");
		 * parkingLotService.parkCar("CA-09-IO-1111");
		 * parkingLotService.parkCar("KA-09-HH-0123"); parkingLotService.getStatus();
		 * }catch(Exception e) {
		 * 
		 * }
		 */
	}

}
