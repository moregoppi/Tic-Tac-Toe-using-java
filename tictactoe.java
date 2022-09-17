import java.util.*;
import java.util.List;
import java.util.random.*;

import javax.swing.text.Position;
public class tictactoe {
    //this function is for printing gameboard
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    //In this function we placing the symbol according to input
    public static void placePiece(char[][] board, int position, String user){
        char symbol=' ';
        if(user.equals("player")){
            symbol='x';
        }else if(user.equals("cpu")){
            symbol='o';
        }

        switch(position){
            case 1:
            board[0][0] = symbol;
                break;
            case 2:
            board[0][2] = symbol;
                break;
            case 3:
            board[0][4] = symbol;
                break;
            case 4:
            board[2][0] = symbol;
                break;
            case 5:
            board[2][2] = symbol;
                break;
            case 6:
            board[2][4] = symbol;
                break;
            case 7:
            board[4][0] = symbol;
                break;
            case 8:
            board[4][2] = symbol;
                break;
            case 9:
            board[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner(){
        List topRow=Arrays.asList(1,2,3);
        List middleRow=Arrays.asList(4,5,6);
        List bottomRow=Arrays.asList(7,8,9);
        
        List firstCol=Arrays.asList(1,4,7);
        List secondCol=Arrays.asList(2,5,8);
        List thirdCol=Arrays.asList(3,6,9);

        List cross1=Arrays.asList(1,5,9);
        List cross2=Arrays.asList(7,5,3);
        return "";
    }
    public static void main(String[] args) {
        char board[][]={{' ','|',' ','|',' '},
                        {'-','+','-','+','-'},
                        {' ','|',' ','|',' '},
                        {'-','+','-','+','-'},
                        {' ','|',' ','|',' '}};
        printBoard(board);
        Scanner sc=new Scanner(System.in);

        

        //here we are makign a loop to take input from user again
        while(true){
            System.out.println("Enter your placement from 1 to 9");
            //here we are taking input from user to place the value
            int playerPos = sc.nextInt();
            placePiece(board, playerPos, "player");

            //here we use random library to take input from cpu a random number
            Random random=new Random();
            int cpuPos = random.nextInt(9) + 1;
            placePiece(board, cpuPos, "cpu");

            //here we are print board
            printBoard(board);
        }
    }
}
