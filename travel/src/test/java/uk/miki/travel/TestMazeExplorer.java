package uk.miki.travel;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.ExplorerTrack;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;
import uk.miki.travel.enums.Direction;
import uk.miki.travel.utility.PrintUtility;

public class TestMazeExplorer {	
	Maze maze;	
	Explorer explorer;
	MazeExplorer mazeExplorer;
	PrintUtility print;
	
	@Before
	public void setUp() throws IOException{		
		print = new PrintUtility();
		
		final String mazeInput = "src/test/resources/Maze1.txt";		
		final MazeFactory mazeFactory = new MazeFactory();
		final ExplorerFactory explorerFactory = new ExplorerFactory();
		
		maze = mazeFactory.createMaze(mazeInput);
		explorer = explorerFactory.createExplorer(maze);
		mazeExplorer = new MazeExplorer(explorer);
	}

	@Test
	public void testExploreMazeDFS() {
		mazeExplorer.exploreMazeDFS();		
		
		print.printExplorerTrackMovements(explorer);
		
		ExplorerTrack track = explorer.getTrack();
		LinkedHashMap<Location, Direction> explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 1, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(8,3) ))
					.count());		
		
		Map<Location, Direction> filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(8,3) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.EAST));
		
	}

}
