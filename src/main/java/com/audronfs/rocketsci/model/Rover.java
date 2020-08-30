package com.audronfs.rocketsci.model;

import java.util.List;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.util.Constants;

public class Rover {

	private Position position;
	private String commands;
	private String errorMessage;
	private int id;
	private static int count;

	public Rover(int x, int y, String orientation, Plateau plateau) throws InvalidInputException {
		id = ++count;

		if (x > plateau.getRight() || y > plateau.getTop() || x < plateau.getLeft() || y < plateau.getBottom()) {
			System.out.println("Rover " + id + " cannot be deployed at position(" + x + ", " + y + ")");
			this.errorMessage = Constants.ROVER_ERROR_FAILED_DEPLOYMENT_BOUNDS;
		}
		position = new Position(x, y, Constants.CARDINAL_POINTS_MAP.get(orientation));
	}

	public static int getRoversCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public String getCommands() {
		return commands;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setCommands(final String commands) {
		this.commands = commands;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void startNavigation(Plateau plateau, List<Rover> roverList) throws InvalidInputException {
		for (char command : getCommands().toCharArray()) {
			Navigation navigation = new Navigation(plateau, this, position, roverList);
			if (command == Constants.LEFT)
				navigation.turnLeft();
			else if (command == Constants.RIGHT)
				navigation.turnRight();
			else if (command == Constants.MOVE)
				navigation.moveForward();
			else {
				this.errorMessage = "Commands are not in the correct format. Please, try L R or M";
				throw new InvalidInputException("Invalid commands");
			}
		}
	}
}



