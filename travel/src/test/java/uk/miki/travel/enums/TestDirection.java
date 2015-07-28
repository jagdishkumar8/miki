package uk.miki.travel.enums;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.miki.travel.enums.Direction;
import uk.miki.travel.utility.PrintUtility;

public class TestDirection {
	PrintUtility print;
	
	@Before
	public void setUp() throws IOException{	
		print = new PrintUtility();
	}

	@Test
	public void testInverted() {
		Direction d = Direction.EAST;		
		print.printDirection(d.inverted());
		assertEquals("Explorer should be facing west",Direction.WEST, d.inverted());
		
		d = Direction.WEST;		
		print.printDirection(d.inverted());
		assertEquals("Explorer should be facing east",Direction.EAST, d.inverted());
		
		d = Direction.NORTH;		
		print.printDirection(d.inverted());
		assertEquals("Explorer should be facing south",Direction.SOUTH, d.inverted());
		
		d = Direction.SOUTH;		
		print.printDirection(d.inverted());
		assertEquals("Explorer should be facing north",Direction.NORTH, d.inverted());
	}
	
	@Test
	public void testRotateLeft() {
		Direction d = Direction.EAST;		
		print.printDirection(d.rotateLeft());
		assertEquals("Explorer should be facing north",Direction.NORTH, d.rotateLeft());
		
		d = Direction.WEST;		
		print.printDirection(d.rotateLeft());
		assertEquals("Explorer should be facing south",Direction.SOUTH, d.rotateLeft());
		
		d = Direction.NORTH;		
		print.printDirection(d.rotateLeft());
		assertEquals("Explorer should be facing west",Direction.WEST, d.rotateLeft());
		
		d = Direction.SOUTH;		
		print.printDirection(d.rotateLeft());
		assertEquals("Explorer should be facing north",Direction.EAST, d.rotateLeft());
	}
	
	@Test
	public void testRotateRight() {
		Direction d = Direction.EAST;		
		print.printDirection(d.rotateRight());
		assertEquals("Explorer should be facing south",Direction.SOUTH, d.rotateRight());
		
		d = Direction.WEST;		
		print.printDirection(d.rotateRight());
		assertEquals("Explorer should be facing north",Direction.NORTH, d.rotateRight());
		
		d = Direction.NORTH;		
		print.printDirection(d.rotateRight());
		assertEquals("Explorer should be facing east",Direction.EAST, d.rotateRight());
		
		d = Direction.SOUTH;		
		print.printDirection(d.rotateRight());
		assertEquals("Explorer should be facing west",Direction.WEST, d.rotateRight());
	}
}