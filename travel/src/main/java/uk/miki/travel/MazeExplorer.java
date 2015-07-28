package uk.miki.travel;

import java.util.List;
import java.util.Random;
import java.util.Stack;

import uk.miki.travel.entities.Explorer;
import uk.miki.travel.entities.Location;
import uk.miki.travel.enums.MazeComponent;
import uk.miki.travel.enums.Move;

public class MazeExplorer {
	private Explorer explorer;
	
	
	public MazeExplorer(Explorer explorer) {
		this.explorer = explorer;
	}
	
	public boolean exploreMazeDFS(){
		Stack<Location> stack = new Stack<Location>();		
		
		stack.push(explorer.getLocation());
		
		while(!stack.isEmpty()){
			final Move move = getRandomAvailableMovement();
			
			if(null == move){
				stack.pop();				
			} else {
				explorer.makeTheMove(move);			

				stack.push(explorer.getLocation());
			}
		}
		
		
		if( MazeComponent.FINISH == explorer.whatsInFront() ){				
			explorer.moveForward();
			return true;
		} 
		
		return false;
		
	}
	
	private Move getRandomAvailableMovement(){
		Random random = new Random();
		
		List<Move> movements = explorer.getAllMovementOptions();
		
		if(movements.size() > 0){
			return movements.get(random.nextInt(movements.size()));
		}
		
		return null;
	}

}