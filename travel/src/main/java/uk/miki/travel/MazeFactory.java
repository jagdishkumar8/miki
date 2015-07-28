package uk.miki.travel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import uk.miki.travel.entities.Coordinate;
import uk.miki.travel.entities.Location;
import uk.miki.travel.entities.Maze;

public class MazeFactory {			
	
	public Maze createMaze(String path) throws IOException{	
		List<Location> walls = new ArrayList<Location>();
		List<Location> spaces = new ArrayList<Location>();
		
		Location start = new Location();
		Location finish = new Location();
			
		List<String> lines = Files.readAllLines(Paths.get(path));
		
		IntStream
		.range(0, lines.size())
		.forEach( r ->  {
							IntStream
								.range(0, ( (String)lines.get(r) ).length()  )
								.filter( ch  ->  ((String)lines.get(r)).charAt(ch)  == 'X' )
								.forEach( c -> { 
									final Location l = new Location( c, r );
									walls.add(l);																		
								});
							
							IntStream
								.range(0, ( (String)lines.get(r) ).length()  )
								.filter( ch  ->  ((String)lines.get(r)).charAt(ch)  == ' ' )
								.forEach( c -> { 
									final Location l = new Location( c, r );
									spaces.add(l);																		
								});
							
							IntStream
								.range(0, ( (String)lines.get(r) ).length()  )
								.filter( ch  ->  ((String)lines.get(r)).charAt(ch)  == 'S' )
								.forEach( c -> { 
									start.setX(new Coordinate(c));
									start.setY(new Coordinate(r));														
								});		

							IntStream
								.range(0, ( (String)lines.get(r) ).length()  )
								.filter( ch  ->  ((String)lines.get(r)).charAt(ch)  == 'F' )
								.forEach( c -> { 
									finish.setX(new Coordinate(c));
									finish.setY(new Coordinate(r));															
								});	
								
		});
		
		final Maze maze = new Maze(walls, spaces, start, finish);
		
		return maze;
	}		
}
