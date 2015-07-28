package uk.miki.travel;

import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.ExplorerTrack;
import uk.miki.travel.entities.Maze;

public class ExplorerFactory {
	MazeFactory mazeFactory;
	
	public Explorer createExplorer(Maze maze){		
		ExplorerTrack track = new ExplorerTrack();
		Explorer explorer =  new Explorer(null, null, maze, track);
		explorer.setLocationToStart();
		explorer.setStartDirection();
		return explorer;
	}

}
