import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//This class is for storing the board
public class Board {
	public int[][] board ; 
	
	public Board(String fileName) throws FileNotFoundException { //Constructor for reading in a board from a text file
	//the numbers must have spaces between them in the text file, and each row must be on a new line	
		// read in the data
		int[][] newboard = new int[9][9] ;
		Scanner input = new Scanner(new File(fileName));
		for(int i = 0; i < 9; ++i)
		{
		    for(int j = 0; j < 9; ++j)
		    {
		        if(input.hasNextInt())
		        {
		            newboard[i][j] = input.nextInt();
		        }
		    }
		}
		input.close();
		this.board = newboard;
	}
	
	public Board() {            //create a new board with all elements 0
		int[][] newboard = new int[9][9] ;
		
		for(int i = 0; i < 9; i++) {
			for(int k =0; k<9;k++) {
				newboard[i][k] = 0;
			}
		}
		
		this.board=newboard;
	}
	
	public Board(int[][] board) {   //initialise a board to an already made board
		this.board=board; 
	}
	
	public boolean isNumberValid(int i, int j, int number) { // Check if a number would be valid at a point
	//This method is very similar to the is point valid, except you provide it the number to check instead of checking the number already there
		if(number<1 || number>9) {
			return(false);
		}else {
			int temp=board[i][j] ; 
			board[i][j] = number ; 
			boolean result = isPointValid(i,j) ; 
			board[i][j] = temp ;
			return(result) ;
		}
		
		
	}
	
	public boolean isPointValid(int i, int j) { //Check if a point is valid by the constraints of sudoku
		//This method checks to see if a point is a valid point on the sudoku board
		boolean result = true ;
		int number= board[i][j] ; 
		int segi=0 , segj = 0;
		if(number==0) {
			return(false);
		}
		
		for(int count=0 ;count < 9 ; count++) {  //Checks down a column
			if(count!=i) {
				if(number==board[count][j]) {
					result=false;
					return(result);
				}
			}
			
			if(count!=j) {                      //checks across a row
				if(number == board[i][count]) {
					result=false;
					return(result);
				}
			}
		}
		
		
		if(i!=0) {                 //This is just to get which block the number is, ie 1,1 would be the middle block
			segi = Math.floorDiv(i, 3); 
		}
		
		if(j!=0) {
			segj = Math.floorDiv(j, 3);
		}
		
		
		for(int counti=3*segi; counti < 3*segi+3; counti++) {       //Check the block if the number repeats
			for(int countj = 3*segj ; countj < 3*segj + 3 ; countj++) {
				if(counti!=i || countj!=j) {
					if(number == board[counti][countj]) {
						result=false;
						return(result) ; 
					}
				}
			}
		}
		
		return(result) ;  //If it passes all these checks, the point is valid
	}
	
	public void setPoint(int i,int j, int number) {  //set a point on the board to a number
	//sets a the ith row and jth column to number;
		if(number<0 || number>9) {
			return;
		}
		this.board[i][j] = number ;
	}
	
	public void printBoard() {
	//This method is used to print the board
		for(int i=0; i<9 ; i++) {
			for(int k = 0 ; k < 9; k++) {
				System.out.print(this.board[i][k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public boolean isBoardValid() {
	//This method checks if the board is valid	
	for(int i = 0; i<9 ; i++) {
		for(int k= 0 ; k<9 ; k++) {
			if(!isPointValid(i,k)) {
				return(false);
			}
		}
	}return(true) ; 
		
	}
	
	public int[] nextPoint(){ // This function finds the coordinates of the next point which is needed to be solved
		for(int i=0; i<9;i++) {
			for(int k=0; k<9 ; k++) {
				if(board[i][k]==0) {
					int[] temp = new int[2] ;
					temp[0]=i;
					temp[1]=k ;
					return(temp) ;
				}
			}
		}
		int[] temp = new int[2] ;
		temp[0]=-1;
		temp[1]=-1 ;
		return(temp) ;
	}

	
}
