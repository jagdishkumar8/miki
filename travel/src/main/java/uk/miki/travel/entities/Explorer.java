package uk.miki.travel.entities;

import java.util.ArrayList;
import java.util.List;

import uk.miki.travel.enums.Direction;
import uk.miki.travel.enums.MazeComponent;
import uk.miki.travel.enums.Move;

public class Explorer {
	private Location location;	
	private Direction direction;
	private Maze maze;
	private ExplorerTrack track;
	
	public Explorer(Location location, Direction direction, Maze maze, ExplorerTrack track){
		this.location = location;
		this.direction = direction;
		this.maze = maze;
		this.track = track;
	}	
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {		
		this.location = location;
		track.addExplorerMovement(this);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		track.addExplorerMovement(this);
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public void setMaze(Maze maze) {
		this.maze = maze;
	}	

	public ExplorerTrack getTrack() {
		return track;
	}

	public void setTrack(ExplorerTrack track) {
		this.track = track;
	}

	public void setLocationToStart() {
		this.location = maze.getStart();
	}		

	public void setStartDirection() {
		this.direction = Direction.SOUTH;
	}

	public void moveForward() {
		this.setLocation(getLocation(Move.FORWARD));
	}

	public void turnLeft() {		
		this.setLocation( getLocation(Move.LEFT) );
		this.setDirection(this.getDirection().rotateLeft());
	}
	
	public void turnRight() {		
		this.setLocation( getLocation(Move.RIGHT) );
		this.setDirection(this.getDirection().rotateRight());	
	}	

	public void moveBackward() {
		this.setLocation( getLocation(Move.BACKWARD) );
		this.turn180Degrees();
	}	
	
	private void turn180Degrees() {
		this.setDirection(this.getDirection().inverted());		
	}

	public MazeComponent whatsInFront() throws IllegalStateException{
		return maze.getAtLocation(  getLocation(Move.FORWARD) );
	}
	
	public List<Move> getAllMovementOptions(){
		List<Move> availableMovements = new ArrayList<Move>();
		
		if(this.canMoveForward()){
			availableMovements.add(Move.FORWARD);
		}	
		if(this.canTurnLeft()){
			availableMovements.add(Move.LEFT);
		}
		if(this.canTurnRight()){
			availableMovements.add(Move.RIGHT);
		}
		
		return availableMovements;	
	}
	
	
	public Location makeTheMove(Move move){
		if(Move.FORWARD == move){
			this.moveForward();
		} else if(Move.BACKWARD == move){
			this.moveBackward();
		} else if(Move.LEFT == move){
			this.turnLeft();
		} else if(Move.RIGHT == move){
			this.turnRight();
		}	
		
		return this.getLocation();
	}
	
	public Location getLocation(Move move){
		Direction direction  = this.getDirection();
		Coordinate x = new Coordinate(location.getX().getU());
		Coordinate y = new Coordinate(location.getY().getU());
		
		if(Move.BACKWARD == move){
			direction = direction.inverted();
		} else if(Move.LEFT == move){
			direction = direction.rotateLeft();
		} else if(Move.RIGHT == move){
			direction = direction.rotateRight();
		}
		
		
		if(Direction.NORTH == direction){
			y.setU(this.location.getY().getU() - 1);
		} else if(Direction.SOUTH == direction){
			y.setU(this.location.getY().getU() + 1);
		} else if(Direction.WEST == direction){
			x.setU(this.location.getX().getU() - 1);
		} else if(Direction.EAST == direction){
			x.setU(this.location.getX().getU() + 1);
		}
		
		return new Location(x, y);
	}


	public boolean canMoveForward(){		
		return canMove(Move.FORWARD);
	}
	
	public boolean canMoveBackward() {
		return canMove(Move.BACKWARD);
	}
	
	public boolean canTurnLeft() {		
		return canMove(Move.LEFT);
	}

	public boolean canTurnRight() {
		return canMove(Move.RIGHT);
	}

	private boolean canMove(Move move) {
		try{
			return (MazeComponent.SPACE == maze.getAtLocation(  getLocation(move) ) ) ? true : false;
		} catch(IllegalStateException e){
			e.printStackTrace();
		}
		
		return false;
	}	
	
}
