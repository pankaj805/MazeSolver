# MazeSolver
A Program that takes an maze as input in the form of 2-D matrix. It finds all the possible paths to exit the maze from all possible entry points
 
#Assumptions
The assumptions and validations handled are as follows:

The details of the maze has to be taken as an input from the user.  
The minimum size of the maze is 2x2 and the maximum size is 10x10 (Max Size can be increased if needed).  
The same path can be traversed bi-directionally  
User can't enter any data other than 0 or 1 for each node of the maze  
Given an maze as below:  
    [0] [0] [1]  
    [1] [1] [0]  
Both of these should be the solution for the maze.  
    {0,2}-->{1,1}  
    {0,2}-->{1,1}-->{1,0}  
The assumption is that, once an exit path is found, it can be extened to find another exit path  
Another assumption is that there should not be a loop in the exit path. So the below path should not be solution  
    {0,2}-->{1,1}-->{1,0}}-->{1,1}   
    

#Running the code
Simply download the file and run the java file. Enter the data as asked by the program. The steps are self explanatory. But still it should be noted that the user is expected to enter the size of the maze (number of rows and number of columns) and the data for each door of the maze.  

Alternatively, the code can be modified to run testcases quickly by avoiding user input. The part of the code which handles user input can be commented and the alternative code can be enabled. 

A working sample of the code can be found in the link below:  
http://www.browxy.com/SavedCode/89978  
Please Note: The uptime of the link is not guranteed.  

#Test cases performed

------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[0] [0] [0] [0] [1]   
[0] [1] [0] [0] [1]   
[1] [1] [0] [0] [0]   
[0] [1] [0] [0] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{3,1}-->{2,1}-->{1,1}-->{2,0}  
{3,1}-->{2,1}-->{2,0}  
{3,1}-->{2,0}  
{0,4}-->{1,4}  
{1,4}-->{0,4}  
{2,0}-->{2,1}-->{3,1}  
{2,0}-->{1,1}-->{2,1}-->{3,1}  
{2,0}-->{3,1}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[0] [0] [0] [0] [1]   
[0] [0] [0] [0] [0]   
[1] [1] [0] [0] [0]   
[0] [0] [0] [0] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
No Luck !! It seems there are no solutions for the given maze!  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[1] [0] [0] [0] [1]   
[0] [1] [0] [1] [0]   
[0] [0] [1] [0] [0]   
[0] [0] [0] [1] [1]   
The List of all possible paths is as below (Node is represented with index numbers):  
{0,0}-->{1,1}-->{2,2}-->{1,3}-->{0,4}  
{0,0}-->{1,1}-->{2,2}-->{3,3}  
{0,0}-->{1,1}-->{2,2}-->{3,3}-->{3,4}  
{3,3}-->{3,4}  
{3,3}-->{2,2}-->{1,1}-->{0,0}  
{3,3}-->{2,2}-->{1,3}-->{0,4}  
{0,4}-->{1,3}-->{2,2}-->{1,1}-->{0,0}  
{0,4}-->{1,3}-->{2,2}-->{3,3}  
{0,4}-->{1,3}-->{2,2}-->{3,3}-->{3,4}  
{3,4}-->{3,3}  
{3,4}-->{3,3}-->{2,2}-->{1,1}-->{0,0}  
{3,4}-->{3,3}-->{2,2}-->{1,3}-->{0,4}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[1] [0] [0] [0] [1]   
[0] [1] [0] [0] [0]   
[0] [0] [1] [0] [0]   
[0] [0] [0] [1] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{0,0}-->{1,1}-->{2,2}-->{3,3}  
{3,3}-->{2,2}-->{1,1}-->{0,0}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
  
The given maze is as below  
[1] [0] [0] [0] [1]   
[0] [1] [0] [0] [0]   
[0] [0] [0] [0] [0]   
[0] [0] [0] [1] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
No Luck !! It seems there are no solutions for the given maze!  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[1] [0] [0]   
[0] [1] [1]   
[0] [1] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{0,0}-->{1,1}-->{2,1}  
{0,0}-->{1,1}-->{2,1}-->{1,2}  
{0,0}-->{1,1}-->{1,2}  
{0,0}-->{1,1}-->{1,2}-->{2,1}  
{2,1}-->{1,1}-->{1,2}  
{2,1}-->{1,1}-->{0,0}  
{2,1}-->{1,2}  
{2,1}-->{1,2}-->{1,1}-->{0,0}  
{1,2}-->{1,1}-->{2,1}  
{1,2}-->{1,1}-->{0,0}  
{1,2}-->{2,1}  
{1,2}-->{2,1}-->{1,1}-->{0,0}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
  
The given maze is as below  
[0] [1] [1]   
[0] [0] [1]   
[0] [0] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{0,1}-->{0,2}  
{0,1}-->{0,2}-->{1,2}  
{0,1}-->{1,2}  
{0,1}-->{1,2}-->{0,2}  
{0,2}-->{0,1}  
{0,2}-->{0,1}-->{1,2}  
{0,2}-->{1,2}  
{0,2}-->{1,2}-->{0,1}  
{1,2}-->{0,2}  
{1,2}-->{0,2}-->{0,1}  
{1,2}-->{0,1}  
{1,2}-->{0,1}-->{0,2}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[0] [1] [0]   
[0] [1] [1]   
[0] [0] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{0,1}-->{1,1}-->{1,2}  
{0,1}-->{1,2}  
{1,2}-->{1,1}-->{0,1}  
{1,2}-->{0,1}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[0] [1] [0]   
[1] [0] [1]   
[0] [0] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{0,1}-->{1,0}  
{0,1}-->{1,2}  
{1,0}-->{0,1}  
{1,0}-->{0,1}-->{1,2}  
{1,2}-->{0,1}  
{1,2}-->{0,1}-->{1,0}  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
  
The given maze is as below  
[0] [0] [1]   
[1] [1] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
{1,0}-->{1,1}  
{1,0}-->{1,1}-->{0,2}  
{1,1}-->{1,0}  
{1,1}-->{0,2}  
{0,2}-->{1,1}  
{0,2}-->{1,1}-->{1,0}  
  
  
------------------------------------------------------------------------------------------------------------------------------------------------  
The given maze is as below  
[1] [0]   
[0] [0]   
The List of all possible paths is as below (Node is represented with index numbers):  
No Luck !! It seems there are no solutions for the given maze!  
  
------------------------------------------------------------------------------------------------------------------------------------------------    
The given maze is as below    
[1] [1]     
[1] [1]    
The List of all possible paths is as below (Node is represented with index numbers):  
{0,0}-->{1,0}  
{0,0}-->{1,0}-->{1,1}  
{0,0}-->{1,0}-->{1,1}-->{0,1}  
{0,0}-->{1,0}-->{0,1}  
{0,0}-->{1,0}-->{0,1}-->{1,1}  
{0,0}-->{0,1}  
{0,0}-->{0,1}-->{1,1}  
{0,0}-->{0,1}-->{1,1}-->{1,0}  
{0,0}-->{0,1}-->{1,0}  
{0,0}-->{0,1}-->{1,0}-->{1,1}  
{0,0}-->{1,1}  
{0,0}-->{1,1}-->{0,1}  
{0,0}-->{1,1}-->{0,1}-->{1,0}  
{0,0}-->{1,1}-->{1,0}  
{0,0}-->{1,1}-->{1,0}-->{0,1}  
{1,0}-->{0,0}  
{1,0}-->{0,0}-->{0,1}  
{1,0}-->{0,0}-->{0,1}-->{1,1}  
{1,0}-->{0,0}-->{1,1}  
{1,0}-->{0,0}-->{1,1}-->{0,1}  
{1,0}-->{1,1}  
{1,0}-->{1,1}-->{0,1}  
{1,0}-->{1,1}-->{0,1}-->{0,0}  
{1,0}-->{1,1}-->{0,0}  
{1,0}-->{1,1}-->{0,0}-->{0,1}  
{1,0}-->{0,1}  
{1,0}-->{0,1}-->{0,0}  
{1,0}-->{0,1}-->{0,0}-->{1,1}  
{1,0}-->{0,1}-->{1,1}  
{1,0}-->{0,1}-->{1,1}-->{0,0}  
{0,1}-->{0,0}  
{0,1}-->{0,0}-->{1,0}  
{0,1}-->{0,0}-->{1,0}-->{1,1}  
{0,1}-->{0,0}-->{1,1}  
{0,1}-->{0,0}-->{1,1}-->{1,0}  
{0,1}-->{1,1}  
{0,1}-->{1,1}-->{1,0}  
{0,1}-->{1,1}-->{1,0}-->{0,0}  
{0,1}-->{1,1}-->{0,0}  
{0,1}-->{1,1}-->{0,0}-->{1,0}  
{0,1}-->{1,0}  
{0,1}-->{1,0}-->{0,0}  
{0,1}-->{1,0}-->{0,0}-->{1,1}  
{0,1}-->{1,0}-->{1,1}  
{0,1}-->{1,0}-->{1,1}-->{0,0}  
{1,1}-->{0,1}  
{1,1}-->{0,1}-->{0,0}  
{1,1}-->{0,1}-->{0,0}-->{1,0}  
{1,1}-->{0,1}-->{1,0}  
{1,1}-->{0,1}-->{1,0}-->{0,0}  
{1,1}-->{1,0}  
{1,1}-->{1,0}-->{0,0}  
{1,1}-->{1,0}-->{0,0}-->{0,1}  
{1,1}-->{1,0}-->{0,1}  
{1,1}-->{1,0}-->{0,1}-->{0,0}  
{1,1}-->{0,0}  
{1,1}-->{0,0}-->{1,0}  
{1,1}-->{0,0}-->{1,0}-->{0,1}  
{1,1}-->{0,0}-->{0,1}  
{1,1}-->{0,0}-->{0,1}-->{1,0}  
