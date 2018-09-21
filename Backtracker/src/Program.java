import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Board board = null;
		try {
			board = new Board("src/UnsolvedBoard.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println(board.isBoardValid());
		boolean t= solveBoard(board);
		board.printBoard();
		System.out.println(board.isBoardValid());
	}
	
	public static boolean solveBoard(Board board) {
		int i,k;
		int[] temp;
		
		temp=board.nextPoint();               //find next 0 in board to fix
		if (temp[0]== -1) {               
			return(true) ;   //No more points to check 
		}
	
		i=temp[0];             //set coordinates
		k=temp[1];
		
		for(int l=1; l<10;l++) {          //iterate through all possible values 1-9
			if(board.isNumberValid(i, k, l)) {  //is the number allowed there
				board.setPoint(i, k, l);        //if yes set it to that
			
				if(solveBoard(board)) {
					return(true);                //if it reaches all the way down the recursive line it returns true all the way up
				}else {
					board.setPoint(i, k, 0);     //if this point failed, reset it to whatever value was there before
				}
			}
		}
		return(false);               //If it can't find any numbers it returns false, then the previous layer of recursion tries another number, ie backtracks
	}
}
