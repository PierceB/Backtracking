import java.io.*;
import java.util.*;

public class checkValid {

    public void makeFile(String input) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> board = new ArrayList<String>(); //arraylist to store the input strings
        int iter = 0;

        while (board.size() <= 8){

            if (input.length() < 17){
                System.out.println("input too short!");
                input = in.nextLine();

            }else if (input.length() > 17){
                System.out.println("input too long!");
                input = in.nextLine();
            }else {

                if (validInput(input)){
                    board.add(input);
                    input = in.nextLine();
                }else {
                    System.out.println("enter valid input!");
                    input = in.nextLine();
                }

            }

            iter++;
        }
        FileWriter writer = new FileWriter("src/inputFile.txt");
        for (String str : board){
            writer.write(str + "\n");
        }
        writer.close();

        System.out.println(board.size());
    }

    public static boolean validInput(String input){
        String[] arr = input.split(" ");

        /*for (String a : arr){

            if (Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 9){
                return true; //this means that the content in the string is a number between 0 and 9
            }
        }*/
        for (int i = 0; i < arr.length ; i++) {
            if (Integer.parseInt(arr[i]) >= 0 && Integer.parseInt(arr[i]) <= 9){
                //condition is true
            }else {
                System.out.println("wrong");
                return false; //this means that the content is not valid
            }

        }
        return true;
    }
}
