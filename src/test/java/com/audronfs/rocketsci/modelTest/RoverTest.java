package com.audronfs.rocketsci.modelTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Rover;

@SuppressWarnings("unused")
public class RoverTest {
	
	/**
	 * TEST: ROVER CLASS WORKS OK
	 * 
	 * @throws InvalidInputException
	 */
//	@Ignore
	@Test
	public void testRoverWorksOk() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);
		// WHEN
		Rover rover = new Rover(1, 2, "E", plateau);
		// THEN
		Assert.assertEquals(1, rover.getPosition().getX());
		Assert.assertEquals(2, rover.getPosition().getY());
		Assert.assertEquals(1, rover.getPosition().getOrientation());
		Assert.assertEquals(1, rover.getId());
	}

	/**
	 * TEST: INVALID INPUT EXCEPTION WORKS OK
	 * 
	 * @throws InvalidInputException
	 */
//	@Ignore
	@Test(expected = InvalidInputException.class)
	public void testInvalidInputException() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);

		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = new Rover(19, 19, "N", plateau);
		rover.setCommands("MBMRL");
		roverList.add(rover);
		// WHEN
		rover.startNavigation(plateau, roverList);

		// THEN
		Assert.assertNotNull(rover.getErrorMessage());
		Assert.fail("Invalid commands");
	}
}
