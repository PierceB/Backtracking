//This class is for storing the board
public class Board {
	public int[][] board ; 
	
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
}
