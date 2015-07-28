package uk.miki.travel.enums;

public enum Direction {
	NORTH("N"),
	EAST("E"),
	SOUTH("S"),	
	WEST("W");
	
	private String value;
	
	Direction(String value){
		this.value = value;
	}
	
	public String direction(){
		return this.value;		
	}	
	
	public Direction inverted(){
		return Direction.values()[(ordinal() + Direction.values().length / 2) % Direction.values().length];
	}

	public Direction rotateLeft() {
		return Direction.values()[(ordinal() + Direction.values().length - 1) % Direction.values().length];
	}
	
	public Direction rotateRight() {
		return Direction.values()[(ordinal() + Direction.values().length + 1) % Direction.values().length];
	}
}
