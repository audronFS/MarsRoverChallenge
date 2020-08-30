package com.audronfs.rocketsci.modelTest;

import org.junit.Test;

import com.audronfs.rocketsci.model.Position;

import org.junit.Assert;

public class PositionTest {

	/**
	 * Test: POSITION WORKS OK
	 */

	@Test
	public void testPositionWorksOk() {

		Position position = new Position(1, 2, 2);

		Assert.assertEquals(1, position.getX());
		Assert.assertEquals(2, position.getY());
		Assert.assertEquals(2, position.getOrientation());
	}
}
