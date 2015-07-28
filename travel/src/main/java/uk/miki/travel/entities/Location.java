package uk.miki.travel.entities;

/**
 * Location is a point in a maze represented by x and y Coordinates
 * 
 * @author jagdish
 *
 */
public class Location {
	
	private Coordinate x;
	private Coordinate y;
	
	public Location(Coordinate x, Coordinate y){
		this.x = x;
		this.y = y;
	}
	
	public Location(int x, int y){
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
	}
	
	public Location() {}

	public Coordinate getX() {
		return x;
	}
	
	public void setX(Coordinate x) {
		this.x = x;
	}
	
	public Coordinate getY() {
		return y;
	}
	
	public void setY(Coordinate y) {
		this.y = y;
	}
	
	public void increaseX(){
		this.x.setU( this.x.getU() + 1);
	}
	
	public void increaseY(){
		this.y.setU(this.y.getU() + 1);
	}
	
	public boolean equals(Object obj){
		if(null == obj || obj.getClass() != this.getClass()){
			return false;
		}
		if(this == obj){
			return true;
		}		
		
		return ( this.getX().getU() == ((Location)obj).getX().getU() && 
				this.getY().getU() == ((Location)obj).getY().getU());
	}	
	
}
