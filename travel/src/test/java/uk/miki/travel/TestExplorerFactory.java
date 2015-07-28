package uk.miki.travel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;
import uk.miki.travel.enums.Direction;

public class TestExplorerFactory {

	Explorer explorer;
	Maze maze;		
	
	@Before
	public void setUp() throws IOException{		
		final String mazeInput = "src/test/resources/Maze1.txt";		
		final MazeFactory mazeFactory = new MazeFactory();
		maze = mazeFactory.createMaze(mazeInput);
	}

	
	@Test
	public void createExplorer() throws IOException{
		final ExplorerFactory explorerFactory = new ExplorerFactory();
		explorer = explorerFactory.createExplorer(maze);		
		
		assertEquals("Explorer start position should be 3,3 ",
				new Location(3, 3),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.SOUTH, explorer.getDirection());
	}

}
