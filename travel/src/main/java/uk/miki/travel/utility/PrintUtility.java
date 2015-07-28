package uk.miki.travel.utility;

import java.util.LinkedHashMap;
import java.util.List;

import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.ExplorerTrack;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;
import uk.miki.travel.enums.Direction;

public class PrintUtility {
	
	public void printMaze(Maze maze){
		List<Location> walls = maze.getWalls();
		List<Location> spaces = maze.getSpaces();
		Location start = maze.getStart();
		Location finish = maze.getFinish();
		
		System.out.println("*******walls************");
		for(Location wall : walls){
			System.out.println("y: " + wall.getY().getU() + " | " +"x: " + wall.getX().getU());
		}
		
		System.out.println("*******spaces************");
		
		for(Location space : spaces){
			System.out.println("y: " + space.getY().getU() + " | " + " x: " + space.getX().getU());
		}
		
		System.out.println("*******start************");
		System.out.println( "y: " + start.getY().getU() + " | " + "x: " + start.getX().getU());
		
		System.out.println("*******finish************");
		System.out.println( "y: " + finish.getY().getU() + " | " + " x: " + finish.getX().getU());		

	}
	
	public void printExplorer(Explorer explorer){
		
		System.out.println("*******explorer position************");
		final Location location = explorer.getLocation();
		System.out.println("x: " + location.getX().getU() + " | y: " + location.getY().getU());
		
		System.out.println("*******explorer direction************");
		final Direction direction = explorer.getDirection();
		System.out.println("Direction: " + direction.direction());
		
	}
	
	
	public void printLocation(Location location){
		
		System.out.println("*******Location************");		
		System.out.println("x: " + location.getX().getU() + " | y: " + location.getY().getU());		
	}
	
	public void printDirection(Direction direction){
		System.out.println("*******Direction************");
		System.out.println("Direction: " + direction.direction());	
	}

	public void printExplorerTrackMovements(Explorer explorer) {
		 ExplorerTrack track = explorer.getTrack();
		 
		 LinkedHashMap<Location, Direction> movements= track.getExplorerMovement();
		 
		 movements.entrySet().stream()
		 .forEach(e -> System.out.println( "x: " + e.getKey().getX().getU() + " | " 
				 + " y: " + e.getKey().getY().getU()  + " | " 
				 + " direction: " + e.getValue().direction()));
		
	}
	
	public void log(Explorer explorer) {
		final Location location = explorer.getLocation();
		final Direction direction = explorer.getDirection();
		
		System.out.println("x: " + location.getX().getU() + " | y: " + location.getY().getU() + " | " + 
		"direction: " + direction.direction());		
	}

}
