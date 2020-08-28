package com.audronfs.rocketsci.model;

import java.util.List;

import com.audronfs.rocketsci.util.Constants;

public class Rover {
	private Position position;
	private String commands;
	private String errorMessage;
	private int id;

	private static int count;
	
public Rover(int x, int y, String orientation, Plateau plateau) {
	id = ++count;
	position = new Position(x, y, Constants.CARDINAL_POINTS_MAP.get(orientation));
		
	}
	
	//Gettters and Setters

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

//Managing Commands

public void startNavigation(Plateau plateau, List<Rover> roverList) {		
	for (char command : getCommands().toCharArray()) {
		if (command == Constants.LEFT)
			turnLeft();
		else if (command == Constants.RIGHT)
			turnRight();
		else if (command == Constants.MOVE)
			moveForward(plateau, roverList);		
		
	}
}	

public void turnLeft() {}

public void turnRight() {}

public void moveForward(Plateau plateau, List<Rover> roverList) {		}
	
}


