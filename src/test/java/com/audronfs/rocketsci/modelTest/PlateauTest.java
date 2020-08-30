package com.audronfs.rocketsci.modelTest;

import org.junit.Assert;
import org.junit.Test;

import com.audronfs.rocketsci.exception.InvalidInputException;
import com.audronfs.rocketsci.model.Plateau;

public class PlateauTest {

	/**
	 * Test: PLATEAU WORKS OK
	 * 
	 * @throws InvalidInputException
	 */

	@Test
	public void testPlateauWorkingOk() throws InvalidInputException {
		// GIVEN
		Plateau plateau = new Plateau();
		// WHEN
		plateau.setCoordinates(30, 50);
		// THEN
		Assert.assertEquals(30, plateau.getRight());
		Assert.assertEquals(50, plateau.getTop());
		Assert.assertEquals(0, plateau.getBottom());
		Assert.assertEquals(0, plateau.getLeft());

	}
}
