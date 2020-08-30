package com.audronfs.rocketsci.modelTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.model.Navigation;
import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Position;
import com.audronfs.rocketsci.model.Rover;
import com.audronfs.rocketsci.util.Constants;

@SuppressWarnings("unused")
public class NavigationTest {
	/**
	 * TEST: NAVIGATION CLASS WORKS OK
	 * 
	 * @throws InvalidInputException
	 */
//	@Ignore
	@Test
	public void testRoverWorksOk() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(10, 15);

		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = new Rover(5, 8, "E", plateau);
		Position position = new Position(5, 8, 1);
		roverList.add(rover);

		Navigation navigation = new Navigation(plateau, rover, position, roverList);

		// WHEN
		navigation.turnLeft();
		// THEN
		Assert.assertEquals(0, position.getOrientation());
		// WHEN
		navigation.turnRight();
		// THEN
		Assert.assertEquals(1, position.getOrientation());
		// WHEN
		navigation.moveForward();
		// THEN
		Assert.assertEquals(6, position.getX());
		Assert.assertEquals(8, position.getY());
		Assert.assertNull(rover.getErrorMessage());
	}

	/**
	 * TEST: TWO ROVERS COLLISION
	 * 
	 * @throws InvalidInputException
	 */
//	@Ignore
	@Test
	public void testRoverCollision() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);

		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = new Rover(1, 2, "N", plateau);
		rover.setCommands("M");
		roverList.add(rover);
		rover.startNavigation(plateau, roverList);

		rover = new Rover(1, 4, "S", plateau);
		rover.setCommands("M");
		roverList.add(rover);
		// WHEN
		rover.startNavigation(plateau, roverList);

		// THEN
		Assert.assertNotNull(rover.getErrorMessage());
		Assert.assertEquals(Constants.ROVER_ERROR_COLLISION, rover.getErrorMessage());

	}

	/**
	 * TEST: TWO ROVERS LAND SAME COORDINATES WITHOUT MOVEMENT
	 * 
	 * @throws InvalidInputException
	 */
	// @Ignore
	@Test
	public void testRoverCollisionLanding() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);

		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = new Rover(1, 2, "N", plateau);
		rover.setCommands("R");
		roverList.add(rover);
		rover.startNavigation(plateau, roverList);

		rover = new Rover(1, 2, "W", plateau);
		rover.setCommands("R");
		roverList.add(rover);
		// WHEN
		rover.startNavigation(plateau, roverList);

		// THEN
		Assert.assertNotNull(rover.getErrorMessage());
		Assert.assertEquals(Constants.ROVER_ERROR_COLLISION, rover.getErrorMessage());

	}

	/**
	 * TEST: ROVER MOVE OUT OF PLATEAU
	 * 
	 * @throws InvalidInputException
	 */
//	@Ignore
	@Test
	public void testRoverMoveOutPlateau() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);

		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = new Rover(19, 19, "N", plateau);
		// WHEN
		rover.setCommands("MM");
		roverList.add(rover);
		rover.startNavigation(plateau, roverList);
		
		// THEN
		Assert.assertNotNull(rover.getErrorMessage());
		Assert.assertEquals(Constants.ROVER_ERROR_OUT_OF_BOUNDS, rover.getErrorMessage());
	}
}
