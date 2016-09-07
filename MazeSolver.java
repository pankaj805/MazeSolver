package maze;

import java.util.Scanner;

public class MazeSolver {
	
	int numRows, numCols; // size of maze
    int maze[][]; // 2-D array to store the maze
    
    static boolean isSolnPresent = false; // flag to check if any solution to the maze was found
    
    int mazeTraversed[][] ; // temporary 2-D array to keep a track of the nodes traversed
    
    
    /* Method to check if the node is accessible */
    public boolean isSafeToGo(int x, int y) {
        // check if x and y are in limits and cell is not blocked
        if (x >= 0 && y >= 0 && x < numRows && y < numCols && maze[x][y] != 0 ) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check if it is an exit
    private  boolean isEdgeAnExit(int x, int y) {
    	
    	if(maze[x][y] ==1){
    		
    		// top edge
            if (x == 0) {
                return true;
            }
            //right edge
            if (y == numCols - 1) {
                return true;
            }

            //left edge
            if (y == 0 ) {
                return true;
            }

            //bottom edge
            if (x == numRows - 1) {
                return true;
            }
    		
    	}        

        return false;
    }

    private  void path(int x, int y, String dir,int init) {
    		
    	/* if exit node has been reached, print the path traversed. It should not print when path function is called for the
    	 * first time. This is handled by the variable init */
        if (isEdgeAnExit(x,y) && mazeTraversed[x][y] != 1 && init != 0 ){ 
        	
        	if(false == MazeSolver.isSolnPresent)
        		MazeSolver.isSolnPresent = true; // set the flag as true to note that at least one solution was found
            System.out.println(dir);
        }
        
        if (mazeTraversed[x][y] == 1){ // if node has already traversed, return back
            return;	
        }
        mazeTraversed[x][y] = 1; // if node has not been traversed earlier, mark it as traversed 
        
        // to go up
        if (isSafeToGo(x - 1, y))
            path(x - 1, y, dir + "-->"+ "{"+(x-1)+","+y+"}",1);
        // to go left
        if (isSafeToGo(x, y - 1))
            path(x, y - 1, dir +  "-->"+ "{"+x+","+(y-1)+"}",1);
        
        //to go down 
        if (isSafeToGo(x + 1, y))
            path(x + 1, y, dir +  "-->"+ "{"+(x+1)+","+y+"}",1);
        
        //to go right
        if (isSafeToGo(x, y + 1))
            path(x, y + 1, dir +  "-->"+ "{"+x+","+(y+1)+"}",1);
        
        //to go to top-left corner (diagonal)
        if (isSafeToGo(x-1, y-1))
            path(x-1, y-1, dir +  "-->"+ "{"+(x-1)+","+(y-1)+"}",1);
        
        
        //to go to top-right corner (diagonal)
        if (isSafeToGo(x-1, y+1))
            path(x-1, y+1, dir +  "-->"+ "{"+(x-1)+","+(y+1)+"}",1);
        
        //to go to bottom-left corner (diagonal)
        if (isSafeToGo(x+1, y-1))
            path(x+1, y-1, dir +  "-->"+"{"+(x+1)+","+(y-1)+"}",1);
        

        //to go to bottom-right corner (diagonal)
        if (isSafeToGo(x+1, y+1))
            path(x+1, y+1, dir + "-->"+ "{"+(x+1)+","+(y+1)+"}",1);
        
        //clearing off the traversed path while backtracking
        mazeTraversed[x][y] =0;
        
        
    }
    
    /*Method to find all possible paths from a particular source*/
    public void findPathForSource(int x, int y){
    	clearTraversedPath();
    	path(x,y,"{"+(x)+","+(y)+"}",0);
    }
    
    // Clearing off the traveredMaze matrix so that it can used to find paths for different sources.
    public void clearTraversedPath(){   	
    	for(int i=0;i<numRows;i++){
    		for(int j=0;j<numCols;j++){
    			mazeTraversed[i][j] = 0;
    		}
    	}
    	
    }
    
    /* Method to identify the Entry points and find all possible paths from them*/
    public void findAllPaths(){
    	
    	// Finding entry points in top and bottom edge
    	for(int col=0;col<numCols;col++){
    		if(maze[0][col] == 1)
    			findPathForSource(0, col);
    		if(maze[numRows-1][col] == 1)
    			findPathForSource(numRows-1, col);
    	}
    	
    	//Finding entry points in left and right edge
    	for(int row=1;row<numRows-1;row++){
    		if(maze[row][0] == 1)
    			findPathForSource(row,0 );
    		if(maze[row][numCols-1] == 1)
    			findPathForSource(row, numCols-1);
    	}
    	
    }

	public static void main(String[] args) {
		
		MazeSolver solver = new MazeSolver();
		
			
		//  Start of code to get Data from User
		Scanner in = new Scanner(System.in);
		
		//Flag to check if entry is valid or not
		boolean isEntryOk = true;
		
		do{
			System.out.println("Enter the number of rows: (Enter  number between 2-10)");
			int rows = in.nextInt();
			if(rows >1 && rows<11){
				solver.numRows = rows;
				isEntryOk = true;
			}else{
				System.out.println("Please Enter a number between 2-10");
				isEntryOk = false;
			}
			
		}while(!isEntryOk);
		
		System.out.println("The number of rows in the input matrix was entered as:"+solver.numRows);
		
		do{
			System.out.println("Enter the number of columns: (Enter  number between 2-10)");
			int cols = in.nextInt();
			if(cols >1 && cols<11){
				solver.numCols = cols;
				isEntryOk = true;
			}else{
				System.out.println("Please Enter a number between 2-10");
				isEntryOk = false;
			}
			
		}while(!isEntryOk);
		
		solver.maze = new int[solver.numRows][solver.numCols];
		solver.mazeTraversed = new int[solver.numRows][solver.numCols];
		
		System.out.println("The number of columns in the input matrix was entered as:"+solver.numCols);
		System.out.println("Please Enter the data for the maze matrix");
		
		for(int row=0;row<solver.numRows;row++){
			
			for(int col=0;col<solver.numCols;col++){
				
				do{
					System.out.println("Enter the data for Row Number:"+(row+1)+" and Column Number:"+(col+1));
					int data = in.nextInt();
					if(data ==0 || data == 1){	
						solver.maze[row][col] = data;
						solver.mazeTraversed[row][col] =0; // Setting up the mazeTraversed matrix at the same time.
						isEntryOk = true;
					}else{
						System.out.println("Please Enter either 0 or 1 as the data for a node in the maze");
						isEntryOk = false;
					}
					
				}while(!isEntryOk);
				
			}
			
		}
				in.close();
		
		
	//  End of code to get Data from User
		
		// Alternate code for running testcases quickly
		/*
		solver.numRows=2;
		solver.numCols=2;
	    solver.maze= new int[][]{{0, 0},
	                 			 {1, 1}};
	                 			 
	                 
	    solver.mazeTraversed = new int[solver.numRows][solver.numCols];
	                 
	    
	    for(int i =0;i<solver.numRows;i++){
	    	for(int j=0;j<solver.numCols;j++){
	    		solver.mazeTraversed[i][j] = 0;
	    	}
	    }
	    */
		//End of Alternate code for running testcases quickly
		
		System.out.println("The given maze is as below");
		
		for(int row=0;row<solver.numRows;row++){
			for(int col=0;col<solver.numCols;col++){
				System.out.print("["+solver.maze[row][col]+ "] ");
			}
			System.out.println();
		}
		

		System.out.println("The List of all possible paths is as below (Node is represented with index numbers):");
		solver.findAllPaths(); // Calling the method to find all possible paths
		
		if(!MazeSolver.isSolnPresent) // If no solution was found. User should be notified
			System.out.println("No Luck !! It seems there are no solutions for the given maze!");

	}

}
