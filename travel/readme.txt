Assumptions
1. Considering each location represented by a coordinate x,y
2. Maze is input via text file and read from top to bottom and left to right
5. Move forward is moving one position in the direction faced by the explorer
6. Move backward is moving back one position achieved by rotate 180 degrees and then forward one position
7. Move right is rotate right and then move forward one position
8. Move left is rotate left and then move forward one position
6. Assuming that explorer is facing South when starting
7. Its not possible for explorer to go out of maze except till Finish
8. Track movements records the updated position first and then the change in direction

Design
1. MazeFactory creates a maze by reading a file Maze1.txt in /resources
2. Maze starts at 0,0. x axis runs from left to right and y axis runs from top to bottom
3. ExplorerFactory creates an explorer, sets the starting position and direction as South
4. Explorer has a maze.
5. MazeExplorer uses depth first search.
4. At each point gets all available movements except backward and then chooses one at random
5. If there are no movements available and is not Finish then explorer moves backwards

Acceptance criteria
The following test the acceptance criteria

User Story 1

1.A Maze (as defined in Maze1.txt consists of walls 'X', Empty spaces ' ', one and only one Start point 'S' and one and only one exit 'F'
	TestMazeFactory -> createMaze()
	
2. After a maze has been created the number of walls and empty spaces should be available to me
	TestMazeFactory -> getNoOfWallsAndSpaces
	
3. After a maze has been created I should be able to put in a co ordinate and know what exists at that point
	TestMazeFactory -> testWhatExistsAtPoint
	
User Story 2	

1.Given a maze the explorer should be able to drop in to the Start point
	ExplorerFactory->createExplorer
	
2. An explorer on a maze must be able to:

	Move forward
		TestExplorer -> testMoveForward
		
	Turn left and right
		TestExplorer -> testTurnLeft, TestExplorer -> testTurnRight
		
	Understand what is in front of the
		TestExplorer -> testWhatsInFront
		
	Understand all movement options from their given location
		TestExplorer -> testGetAllMovementOptions
		
	Have a record of where they have been
		TestExplorer -> testRecordOfWhereExplorerHaveBeen
		
3. Once an explorer has exited a maze they must be able to state the route they took in an understandable fashion
		TestMazeExplorer -> testExploreMazeDFS