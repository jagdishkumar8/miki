package uk.miki.travel.entities;

import java.util.LinkedHashMap;

import uk.miki.travel.enums.Direction;

public class ExplorerTrack {
	LinkedHashMap<Location, Direction> explorerTack;
	
	public ExplorerTrack(){
		explorerTack = new LinkedHashMap<Location, Direction>();
	}


	public void addExplorerMovement(Explorer explorer) {
		explorerTack.put(new Location(explorer.getLocation().getX(), explorer.getLocation().getY()), explorer.getDirection());		
	}
	
	
	public LinkedHashMap<Location, Direction> getExplorerMovement(){
		return this.explorerTack;
	}

}
