import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
       // String str = in.nextLine();
       /* checkValid check = new checkValid();
        try {
            check.makeFile(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Board board = null;
        try {
            board = new Board("src/inputFile.txt");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }*/ 
        
        int[][] tempboard=new int[9][9];
        
        for(int i=0; i<9;i++) {
        	String str = in.nextLine();
        	String[] temp = str.split(" ");
        	int l=temp.length;
        	
        	for(int k=0; k<l;k++) {
        		tempboard[i][k] = Integer.parseInt(temp[k]) ; 
        	}
        }
        
        Board board = new Board(tempboard);
        
        //System.out.println(board.isBoardValid());
        solveBoard(board);
        board.printBoard();
        //System.out.println(board.isBoardValid());
    }

    public static boolean solveBoard(Board board){
        int i, j;
        int[] temp;

        temp = board.nextPoint();
        if (temp[0] == -1){
            return true;
        }

        i = temp[0];
        j = temp[1];

        for (int k = 1; k <= 9 ; k++) {
            if (board.isNumberValid(i, j, k)){
                board.setPoint(i, j, k);

                if (solveBoard(board)){
                    return true;
                }else {
                    board.setPoint(i, j, 0);
                }
            }
        }
        return false;
    }
}
