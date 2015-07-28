package uk.miki.travel.enums;

public enum MazeComponent {
	WALL("Wall"),
	SPACE("Space"),
	START("Starting Point"),
	FINISH("Finishing Point");
	
	private String value;
	
	MazeComponent(String value){
		this.value = value;
	}
	
	public String component(){
		return this.value;
	}
}
