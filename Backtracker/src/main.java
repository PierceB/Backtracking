import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Board board = null;
		try {
			board = new Board("src/Board.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println(board.isBoardValid());
		board.printBoard();
	}

}
