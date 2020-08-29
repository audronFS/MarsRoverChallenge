package com.audronfs.rocketsci.modelTest;

import org.junit.Assert;
import org.junit.Test;

import com.audronfs.rocketsci.model.Plateau;
import com.audronfs.rocketsci.model.Rover;

public class RoverTest {
	/**
	 * TEST: ROVER CLASS WORKS OK
	 * @throws InvalidInputException 
	 */
	
	@Test
	public void testRoverWorksOk() {
		//GIVEN
		Plateau plateau = new Plateau();
		plateau.setCoordinates(20, 20);		
		//WHEN
		Rover rover = new Rover(1,2,"E",plateau);
		//THEN
		Assert.assertEquals(1,rover.getPosition().getX());
		Assert.assertEquals(2,rover.getPosition().getY());
		Assert.assertEquals(1,rover.getPosition().getOrientation());
		Assert.assertEquals(1,rover.getId());	
	}
}
