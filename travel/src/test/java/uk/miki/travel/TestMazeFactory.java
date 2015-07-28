package uk.miki.travel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;
import uk.miki.travel.enums.MazeComponent;
import uk.miki.travel.utility.PrintUtility;

public class TestMazeFactory {
	
	String mazeInput;
	MazeFactory mazeFactory;
	Maze maze;
	Explorer explorer;
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
	public void createMaze() throws IOException {		
		final Maze m = mazeFactory.createMaze(mazeInput);
		
		print.printMaze(m);
		
		assertEquals("Starting location is expected to be 3,3" , m.getStart(), new Location(3, 3));
		assertEquals("Finishing location is expected to be 1,14" , m.getFinish(), new Location(1, 14));		
	}
	
	@Test
	public void testWhatExistsAtPoint() throws Exception {
		MazeComponent component;
				
		Location wall = new Location(7, 4);	
		component = maze.getAtLocation(wall);
		assertEquals("Expecting to find a wall", MazeComponent.WALL, component);	

		Location space = new Location(8 ,6);
		component = maze.getAtLocation(space);
		assertEquals("Expecting to find a space", MazeComponent.SPACE, component);

		Location start = new Location(3, 3);
		component = maze.getAtLocation(start);
		assertEquals("Expecting to find a Starging point", MazeComponent.START, component);
		
		Location finish = new Location(1, 14);
		component = maze.getAtLocation(finish);
		assertEquals("Expecting to find a Finishing point", MazeComponent.FINISH, component);	
	}
	
	
	@Test
	public void testOutOfRange() throws Exception{
		Location outOfRange = new Location(55, 56);
		
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("Unexpected exception");
		@SuppressWarnings("unused")
		final MazeComponent component = maze.getAtLocation(outOfRange);
	}
	
	@Test
	public void getNoOfWallsAndSpaces() throws IOException{
				
		assertEquals("There should be total of 13 walls", 149, maze.getWalls().size());
		assertEquals("There should be total of 74 empty spaces", 74, maze.getSpaces().size());
	}	
}
