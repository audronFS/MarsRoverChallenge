package com.audronfs.rocketsci.operationTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Rover;
import com.audronfs.rocketsci.operation.MarsRoverOperation;
import com.audronfs.rocketsci.util.Constants;

public class MarsRoverOperationTest {

	/**
	 * Test: TWO ROVERS WORKING OK
	 * 
	 * @throws InvalidInputException
	 */
	@Ignore
	@Test
	public void testTwoRoversWorkingOk() throws InvalidInputException {
		// GIVEN
		MarsRoverOperation marsRoverOperation = new MarsRoverOperation();

		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);

		List<Rover> roverList = new ArrayList<Rover>();
		Rover rover = new Rover(0, 0, "N", plateau);
		rover.setCommands("MMRM");// 1,2,E
		roverList.add(rover);
		rover = new Rover(5, 6, "S", plateau);
		rover.setCommands("MMLM");// 6,4,E
		roverList.add(rover);

		marsRoverOperation.setPlateau(plateau);
		marsRoverOperation.setRoverList(roverList);

		// WHEN
		marsRoverOperation.operateRovers();

		// THEN
		Assert.assertNull(roverList.get(0).getErrorMessage());
		Assert.assertEquals(1, roverList.get(0).getPosition().getX());
		Assert.assertEquals(2, roverList.get(0).getPosition().getY());
		Assert.assertEquals(1, roverList.get(0).getPosition().getOrientation());

		Assert.assertNull(roverList.get(1).getErrorMessage());
		Assert.assertEquals(6, roverList.get(1).getPosition().getX());
		Assert.assertEquals(4, roverList.get(1).getPosition().getY());
		Assert.assertEquals(1, roverList.get(1).getPosition().getOrientation());

	}

	/**
	 * TEST: CHECK INPUT WORKING OK
	 * 
	 * @throws InvalidInputException
	 */
	// @Ignore
	@Test
	public void testCheckInputWorkingFalse() throws InvalidInputException {
		// GIVEN
		MarsRoverOperation marsRoverOperation = new MarsRoverOperation();
		// WHEN
		Boolean checker = marsRoverOperation.checkInput("20,-1", Constants.PLATEAU);
		// THEN
		Assert.assertFalse(checker);
		// WHEN
		checker = marsRoverOperation.checkInput("20,80,G", Constants.ROVER);
		// THEN
		Assert.assertFalse(checker);
	}

	public void testCheckInputWorkingTrue() throws InvalidInputException {
		// GIVEN
		MarsRoverOperation marsRoverOperation = new MarsRoverOperation();
		// WHEN
		Boolean checker = marsRoverOperation.checkInput("15,30", Constants.PLATEAU);
		// THEN
		Assert.assertFalse(checker);
		// WHEN
		checker = marsRoverOperation.checkInput("10,9,W", Constants.ROVER);
		// THEN
		Assert.assertFalse(checker);
	}
}
