package com.audronfs.rocketsci.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Rover;
import com.audronfs.rocketsci.util.Constants;

public class MarsRoverOperation {

	private Plateau plateau = new Plateau();
	private List<Rover> roverList = new ArrayList<Rover>();

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void setRoverList(List<Rover> roverList) {
		this.roverList = roverList;
	}

	public List<Rover> getRoverList() {
		return this.roverList;
	}

	public void parsePlateau(Scanner scanner) throws InvalidInputException {
		String plateauCoordinates;
		do {
			System.out.println("Plateau dimentions (format example: 20,20). Coordinate must be greater than 0: ");
			plateauCoordinates = scanner.next();
		} while (!checkInput(plateauCoordinates, Constants.PLATEAU));
		setPlateauCoordinates(plateauCoordinates);
	}

	public void parseRover(Scanner scanner) throws InvalidInputException {
		String roverPosition;
		Boolean moreRovers = Boolean.TRUE;
		Integer roverIndex = 0;
		while (moreRovers == Boolean.TRUE) {
			roverIndex++;
			do {
				System.out.println(
						"Rover " + roverIndex + " position (format example: 1,2,N). Cardinal points are N, W, E or S:");
				roverPosition = scanner.next().toUpperCase();
			} while (!checkInput(roverPosition, Constants.ROVER));
			Rover rover = initializeRover(roverPosition);

			System.out.println("Rover " + roverIndex + " commands (format example: LLMMMRMLMM):");
			String roverCommands = scanner.next().toUpperCase();
			System.out.println("Do you want to deploy another rover? (Y/N):");
			moreRovers = "Y".equals(scanner.next().toUpperCase()) ? Boolean.TRUE : Boolean.FALSE;
			rover.setCommands(roverCommands);
			roverList.add(rover);
		}
	}

	public Boolean checkInput(String input, String id) {
		Pattern pattern;
		if (id.equals("Plateau")) {
			pattern = Pattern.compile("([0-9]+),([0-9]+)$");
		} else {
			pattern = Pattern.compile("([0-9]+),([0-9]+)(,[NSEW])$");
		}
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return Boolean.TRUE;
		} else {
			System.out.println("Invalid input format. Please, try again");
			return Boolean.FALSE;
		}
	}

	private void setPlateauCoordinates(String rawPlateauCoordinates) throws InvalidInputException {
		String[] tokens;
		tokens = rawPlateauCoordinates.split(Constants.SEPARATOR_SPLIT_CHARACTER);
		int right = Integer.parseInt(tokens[0]);
		int top = Integer.parseInt(tokens[1]);
		plateau.setCoordinates(right, top);
	}

	private Rover initializeRover(String rawRoverPosition) throws InvalidInputException {
		Rover rover;
		String[] tokens;
		tokens = rawRoverPosition.split(Constants.SEPARATOR_SPLIT_CHARACTER);
		int x = Integer.parseInt(tokens[0]);
		int y = Integer.parseInt(tokens[1]);
		String orientation = tokens[2];
		rover = new Rover(x, y, orientation, plateau);
		return rover;
	}

	public void operateRovers() {
		for (Rover rover : roverList) {
			try {
				rover.startNavigation(plateau, roverList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void displayAnalysis(String prefix) {
		System.out.println("\n" + prefix + " ANALYSIS");
		System.out.println("Plateau Size: " + plateau.getRight() + ", " + plateau.getTop());
		for (Rover rover : roverList) {
			System.out.println("Rover " + rover.getId() + ":");
			if (rover.getErrorMessage() == null) {
				System.out.println("\t->Position: x = " + rover.getPosition().getX() + ", y = "
						+ rover.getPosition().getY() + ",orientation = "
						+ Constants.CARDINAL_INDEX_MAP.get(rover.getPosition().getOrientation()));
				if (Constants.INITIAL.equals(prefix)) {
					System.out.println("\t->Commands: " + rover.getCommands());
				}
			} else {
				System.out.println("\t->Error Message: " + rover.getErrorMessage());
			}
		}
	}
}