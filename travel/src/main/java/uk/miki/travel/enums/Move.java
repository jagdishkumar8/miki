package uk.miki.travel.enums;

public enum Move {
	FORWARD("F"),
	BACKWARD("B"),
	RIGHT("R"),
	LEFT("L");
	
	private String value;
	
	Move(String value){
		this.value = value;
	}
	
	public String move(){
		return this.value;
	}
}