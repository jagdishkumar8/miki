package uk.miki.travel.entities;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import uk.miki.travel.entities.Coordinate;

public class TestCoordinate extends TestCase {
	private Coordinate coordinate;	

	@Before
	public void setUp(){
		coordinate = new Coordinate(3);
	}
	
	@Test
	public void testIncrease() {
		assertEquals(4, coordinate.increase().getU());
	}

	@Test
	public void testDecrease() {
		assertEquals(2, coordinate.decrease().getU());
	}

}