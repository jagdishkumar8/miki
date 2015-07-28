package uk.miki.travel.entities;

import java.util.List;

import uk.miki.travel.enums.MazeComponent;

public class Maze {
	private List<Location> walls;
	private List<Location> spaces;
	
	private Location start;
	private Location finish;
	
	public Maze(List<Location> walls, List<Location> spaces, Location start, Location finish){
		this.walls = walls;
		this.spaces = spaces;
		this.start = start;
		this.finish = finish;
	}
	
	public List<Location> getWalls() {
		return walls;
	}

	public void setWalls(List<Location> walls) {
		this.walls = walls;
	}

	public List<Location> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Location> spaces) {
		this.spaces = spaces;
	}

	public Location getStart() {
		return start;
	}
	
	public void setStart(Location start) {
		this.start = start;
	}
	
	public Location getFinish() {
		return finish;
	}

	public void setFinish(Location finish) {
		this.finish = finish;
	}
	
	public MazeComponent getAtLocation(Location location) throws IllegalStateException{
		
		if(walls.stream()
				.filter(l -> l.equals(location) )
				.count() > 0){			
			return MazeComponent.WALL;
		}
		if(spaces.stream()
				.filter(l -> l.equals(location)) 
				.count() > 0){			
			return MazeComponent.SPACE;
		}
		if(start.equals(location)){			
			return MazeComponent.START;
		}
		if(finish.equals(location)){
			return MazeComponent.FINISH;
		}
		
		throw new IllegalStateException("Unexpected exception");		
	}
	
}
