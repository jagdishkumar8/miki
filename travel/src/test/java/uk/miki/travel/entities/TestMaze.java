package uk.miki.travel.entities;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import uk.miki.travel.MazeFactory;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;
import uk.miki.travel.enums.MazeComponent;
import uk.miki.travel.utility.PrintUtility;

public class TestMaze {
	String mazeInput;
	MazeFactory mazeFactory;
	Maze maze;
	PrintUtility print;
	
	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Before
	public void setUp() throws IOException{		
		mazeInput = "src/test/resources/Maze1.txt";		
		mazeFactory = new MazeFactory();
		maze = mazeFactory.createMaze(mazeInput);
		print = new PrintUtility();
	}

	@Test
	public void testGetAtLocation() {		
		MazeComponent component = maze.getAtLocation(new Location(3,4));
		assertEquals("Wall is expected at 3,4" , MazeComponent.WALL, component);
	}

}
