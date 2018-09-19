
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Board board = new Board() ;  
		board.setPoint(0, 0, 4);
		boolean temp = board.isNumberValid(2, 2,4) ; 
		System.out.println(temp);
		
		board.printBoard();
	}

}
