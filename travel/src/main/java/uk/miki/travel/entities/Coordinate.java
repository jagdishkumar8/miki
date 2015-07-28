package uk.miki.travel.entities;


/**
 * Unit is the unit in a coordinate ordered pair
 * unit u can be x or y
 * 
 * @author jagdish
 *
 */
public class Coordinate {
	private int u;
	
	public Coordinate(int u){
		this.u = u;
	}
	
	public int getU() {
		return u;
	}

	public void setU(int u){
		this.u = u;
	}
	
	public Coordinate increase(){
		this.u = this.u+1;
		return this;
		
	}
	
	public Coordinate decrease(){
		this.u = this.u-1;
		return this;
	}
	
	public boolean equals(Object obj){
		if(null == obj || obj.getClass() != this.getClass()){
			return false;
		}
		if(this == obj){
			return true;
		}		
		
		return this.getU() == ((Coordinate)obj).getU();
	}
}
