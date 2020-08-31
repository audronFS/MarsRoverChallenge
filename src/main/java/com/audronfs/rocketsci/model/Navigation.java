package com.audronfs.rocketsci.model;

import java.util.List;

import com.audronfs.rocketsci.util.Constants;

public class Navigation {

	private Rover rover;
	private Plateau plateau;
	private List<Rover> roverList;
	private Position position;

	public Navigation(Plateau plateau, Rover rover, Position position, List<Rover> roverList) {
		this.rover = rover;
		this.plateau = plateau;
		this.roverList = roverList;
		this.position = position;
	}

	public void turnLeft() {
		if (checkCollision()) {
			rover.setErrorMessage(Constants.ROVER_ERROR_COLLISION);
		} else {
			int left = ((position.getOrientation() == 0) ? Constants.CARDINAL_POINTS.length : position.getOrientation())
					- 1;
			position.setOrientation(left);
		}
	}

	public void turnRight() {
		if (checkCollision()) {
			rover.setErrorMessage(Constants.ROVER_ERROR_COLLISION);
		} else {
			int right = (position.getOrientation() + 1) % Constants.CARDINAL_POINTS.length;
			position.setOrientation(right);
		}
	}

	public void moveForward() {
		if (rover.getErrorMessage() == null) {
			switch (Constants.CARDINAL_POINTS[position.getOrientation()]) {
			case Constants.NORTH:
				moveForwardToNorth();
				break;
			case Constants.EAST:
				moveForwardToEast();
				break;
			case Constants.SOUTH:
				moveForwardToSouth();
				break;
			case Constants.WEST:
				moveForwardToWest();
				break;
			}
		}
	}

	private void moveForwardToWest() {
		if (position.getX() > plateau.getLeft()) {
			position.setVirtualX(position.getVirtualX() - 1);
			if (checkCollision()) {
				rover.setErrorMessage(Constants.ROVER_ERROR_COLLISION);
			} else {
				position.setX(position.getX() - 1);
			}
		} else {
			rover.setErrorMessage(Constants.ROVER_ERROR_OUT_OF_BOUNDS);
		}
	}

	private void moveForwardToSouth() {
		if (position.getY() > plateau.getBottom()) {
			position.setVirtualY(position.getVirtualY() - 1);
			if (checkCollision()) {
				rover.setErrorMessage(Constants.ROVER_ERROR_COLLISION);
			} else {
				position.setY(position.getY() - 1);
			}
		} else {
			rover.setErrorMessage(Constants.ROVER_ERROR_OUT_OF_BOUNDS);
		}
	}

	private void moveForwardToEast() {
		if (position.getX() < plateau.getRight()) {
			position.setVirtualX(position.getVirtualX() + 1);
			if (checkCollision()) {
				rover.setErrorMessage(Constants.ROVER_ERROR_COLLISION);
			} else {
				position.setX(position.getX() + 1);
			}
		} else {
			rover.setErrorMessage(Constants.ROVER_ERROR_OUT_OF_BOUNDS);
		}
	}

	private void moveForwardToNorth() {
		if (position.getY() < plateau.getTop()) {
			position.setVirtualY(position.getVirtualY() + 1);
			if (checkCollision()) {
				rover.setErrorMessage(Constants.ROVER_ERROR_COLLISION);
			} else {
				position.setY(position.getY() + 1);
			}
		} else {
			rover.setErrorMessage(Constants.ROVER_ERROR_OUT_OF_BOUNDS);
		}
	}

	public Boolean checkCollision() {
		for (Rover rover : roverList) {
			if (rover.getId() != this.rover.getId() && rover.getPosition().getX() == position.getVirtualX()
					&& rover.getPosition().getY() == position.getVirtualY()) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}
