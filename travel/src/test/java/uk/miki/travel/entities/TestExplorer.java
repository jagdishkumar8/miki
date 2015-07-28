package uk.miki.travel.entities;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import uk.miki.travel.ExplorerFactory;
import uk.miki.travel.MazeFactory;
import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.ExplorerTrack;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;
import uk.miki.travel.enums.Direction;
import uk.miki.travel.enums.MazeComponent;
import uk.miki.travel.enums.Move;
import uk.miki.travel.utility.PrintUtility;

public class TestExplorer {
	
	Explorer explorer;
	Maze maze;		
	PrintUtility print;
	
	@Before
	public void setUp() throws IOException{		
		print = new PrintUtility();
		
		final String mazeInput = "src/test/resources/Maze1.txt";		
		final MazeFactory mazeFactory = new MazeFactory();
		final ExplorerFactory explorerFactory = new ExplorerFactory();
		
		maze = mazeFactory.createMaze(mazeInput);
		explorer = explorerFactory.createExplorer(maze);		
	}
	

	@Test
	public void testMoveForward() {
		explorer.moveForward();
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 3,4 ",
				new Location(3, 4),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.SOUTH, explorer.getDirection());
		
		ExplorerTrack track = explorer.getTrack();
		LinkedHashMap<Location, Direction> explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 1, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(3, 4) ))
					.count());		
		
		Map<Location, Direction> filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(3, 4) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.SOUTH));
		
	}

	@Test
	public void testTurnLeft() {
		explorer.turnLeft();
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 4,3 ",
				new Location(4, 3),  explorer.getLocation());
		assertEquals("Explorer should be facing east",Direction.EAST, explorer.getDirection());
		
		ExplorerTrack track = explorer.getTrack();
		LinkedHashMap<Location, Direction> explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 2, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(4, 3) ))
					.count());		
		
		Map<Location, Direction> filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(4, 3) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.EAST));
	}

	@Test
	public void testTurnRight() {		
		explorer.turnRight();
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 2,3 ",
				new Location(2, 3),  explorer.getLocation());
		assertEquals("Explorer should be facing west",Direction.WEST, explorer.getDirection());
		
		ExplorerTrack track = explorer.getTrack();
		LinkedHashMap<Location, Direction> explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 2, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(2, 3) ))
					.count());		
		
		Map<Location, Direction> filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(2, 3) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.WEST));
	}

	@Test
	public void testMoveBackward() {	
		explorer.moveBackward();
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 3,2 ",
				new Location(3, 2),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.NORTH, explorer.getDirection());
		
		ExplorerTrack track = explorer.getTrack();
		LinkedHashMap<Location, Direction> explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 2, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(3, 2) ))
					.count());		
		
		Map<Location, Direction> filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(3, 2) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.NORTH));
	}

	@Test
	public void testWhatsInFront() {
		MazeComponent component = explorer.whatsInFront();
		assertEquals("There should be a space in front ",
				MazeComponent.WALL,  component);
		
		explorer.setLocation(new Location(1, 13));
		component = explorer.whatsInFront();
		assertEquals("There should be a wall in front ",
				MazeComponent.FINISH,  component);
	}
	
	@Test
	public void testGetLocation(){
		print.printLocation(explorer.getLocation());
		
		Location location = explorer.getLocation(Move.FORWARD);
		print.printLocation(location);		
		assertEquals("Explorer position should be 3,4 ",
				new Location(3, 4),  location);
		
		location = explorer.getLocation(Move.BACKWARD);
		print.printLocation(location);		
		assertEquals("Explorer position should be 3,2",
				new Location(3, 2),  location);
		
		location = explorer.getLocation(Move.LEFT);
		print.printLocation(location);		
		assertEquals("Explorer position should be 4,3",
				new Location(4, 3),  location);
		
		location = explorer.getLocation(Move.RIGHT);
		print.printLocation(location);		
		assertEquals("Explorer position should be 2,3",
				new Location(2, 3),  location);
	}

	@Test
	public void testGetForwardLocation() {
		
		print.printLocation(explorer.getLocation());
		
		Location location = explorer.getLocation(Move.FORWARD);
		print.printLocation(location);		
		assertEquals("Explorer position should be 3,4 ",
				new Location(3, 4),  location);
		
		
		explorer.setDirection(Direction.NORTH);
		location = explorer.getLocation(Move.FORWARD);
		print.printLocation(location);	
		assertEquals("Explorer position should be 3,2 ",
				new Location(3, 2),  location);
		
		explorer.setDirection(Direction.EAST);
		location = explorer.getLocation(Move.FORWARD);
		print.printLocation(location);
		assertEquals("Explorer position should be 4,3 ",
				new Location(4, 3),  location);		
		
		explorer.setDirection(Direction.WEST);
		location = explorer.getLocation(Move.FORWARD);
		print.printLocation(location);
		assertEquals("Explorer position should be 2,3 ",
				new Location(2, 3),  location);		
		
		location = new Location(8 ,9);
		explorer.setLocation(location);
		explorer.setDirection(Direction.WEST);
		location = explorer.getLocation(Move.FORWARD);
		print.printLocation(location);
		assertEquals("Explorer position should be 7,9 ",
				new Location(7 ,9),  location);	
	}

	@Test
	public void testCanMoveForward() {
		print.printLocation(explorer.getLocation());		
			
		assertEquals("Explorer can move forward ",
				false,  explorer.canMoveForward());	
		
		Location location = new Location(13, 2);
		explorer.setLocation(location);
		print.printLocation(explorer.getLocation());
		assertEquals("Explorer cannot move forward ",
				true,  explorer.canMoveForward());			
	}
	
	@Test
	public void testcanMoveBackward() {
		print.printLocation(explorer.getLocation());
		
		assertEquals("Explorer cannot move backward ",
				false,  explorer.canMoveBackward());	
		
		Location location = new Location(13, 13);
		explorer.setLocation(location);
		print.printLocation(explorer.getLocation());
		assertEquals("Explorer can move backward ",
				true,  explorer.canMoveBackward());	
	}
	
	@Test
	public void testCanTurnLeft() {
		print.printLocation(explorer.getLocation());
		
		assertEquals("Explorer cannot turn left ",
				true,  explorer.canTurnLeft());	
		
		Location location = new Location(12, 13);
		explorer.setLocation(location);
		print.printLocation(explorer.getLocation());
		assertEquals("Explorer can turn left ",
				true,  explorer.canTurnLeft());	
	}

	@Test
	public void testCanTurnRight() {
		print.printLocation(explorer.getLocation());
		
		assertEquals("Explorer cannot turn left ",
				false,  explorer.canTurnRight());	
		
		Location location = new Location(13, 13);
		explorer.setLocation(location);
		print.printLocation(explorer.getLocation());
		assertEquals("Explorer can turn left ",
				true,  explorer.canTurnRight());	
	}
	
	@Test
	public void testGetAllMovementOptions(){
		print.printLocation(explorer.getLocation());
		
		List<Move> allMovements = explorer.getAllMovementOptions();
		
		assertEquals("There is only one movement option at this location" , 1,
		allMovements
			.stream()
			.count());
		
		Location location = new Location(13, 13);
		explorer.setLocation(location);
		print.printLocation(explorer.getLocation());
		assertEquals("There is only one movement option at this location" , 1,
		allMovements
			.stream()
			.count());		
	}
	
	
	@Test
	public void testMakeTheMove(){
		explorer.makeTheMove(Move.FORWARD);
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 3,4 ",
				new Location(3, 4),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.SOUTH, explorer.getDirection());
		
		explorer.makeTheMove(Move.BACKWARD);
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 3,3 ",
				new Location(3, 3),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.NORTH, explorer.getDirection());
		
		explorer.makeTheMove(Move.LEFT);
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 2,3 ",
				new Location(2, 3),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.WEST, explorer.getDirection());		
		
		explorer.makeTheMove(Move.RIGHT);
		print.printExplorer(explorer);
		assertEquals("Explorer position should be 2,2 ",
				new Location(2, 2),  explorer.getLocation());
		assertEquals("Explorer should be facing south",Direction.NORTH, explorer.getDirection());		
		
	}
	
	@Test
	public void testRecordOfWhereExplorerHaveBeen(){
		explorer.moveForward();
		print.printExplorer(explorer);
		
		ExplorerTrack track = explorer.getTrack();
		LinkedHashMap<Location, Direction> explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 1, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(3, 4) ))
					.count());		
		
		Map<Location, Direction> filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(3, 4) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.SOUTH));
		
		explorer.turnLeft();
		print.printExplorer(explorer);
		
		track = explorer.getTrack();
		explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 2, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(4, 4) ))
					.count());		
		
		filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(4, 4) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.EAST));	
		
		explorer.moveBackward();
		print.printExplorer(explorer);
		
		track = explorer.getTrack();
		explorerMovement = track.getExplorerMovement();
		
		assertEquals("Should be recored in explorer movement", 3, 
				explorerMovement.entrySet().stream()
					.filter(e -> e.getKey().equals(new Location(3, 4) ))
					.count());		
		
		filtered = 
				explorerMovement.entrySet()
				.stream()
				.filter(e -> e.getKey().equals(new Location(3, 4) ))
				.collect(Collectors.toMap( e -> e.getKey(), e -> e.getValue() ));
		

		assertEquals("Direction should be recorded", true, filtered.values().contains(Direction.WEST));		
	}
}