import java.util.*;
import java.util.List;
import java.util.random.*;

import javax.swing.text.Position;
public class tictactoe {

    static ArrayList<Integer> playerpositons=new ArrayList<Integer>();
    static ArrayList<Integer> cpupositons=new ArrayList<Integer>();

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
            playerpositons.add(position);
        }else if(user.equals("cpu")){
            symbol='o';
            cpupositons.add(position);
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

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(firstCol);
        winning.add(secondCol);
        winning.add(thirdCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning){
            if(playerpositons.containsAll(l)){
                return "Congratualtion you won!";
            }else if(cpupositons.containsAll(l)){
                return "CPU wins! Sorry :(";
            }else if(playerpositons.size() + cpupositons.size() == 9){
                return "No one wins its tie";
            }
        }

        return "";
    }
    public static void main(String[] args) {
        char board[][]={{' ','|',' ','|',' '},
                        {'-','+','-','+','-'},
                        {' ','|',' ','|',' '},
                        {'-','+','-','+','-'},
                        {' ','|',' ','|',' '}};
        printBoard(board);

        

        //here we are makign a loop to take input from user again
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your placement from 1 to 9");
            //here we are taking input from user to place the value
            int playerPos = sc.nextInt();
            while(playerpositons.contains(playerPos) || cpupositons.contains(playerPos)){
                System.out.println("Positon taken! Enter a correct position");
                playerPos =sc.nextInt();
            }
            placePiece(board, playerPos, "player");
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
            //here we use random library to take input from cpu a random number
            Random random=new Random();
            int cpuPos = random.nextInt(9) + 1;
            
            while(playerpositons.contains(cpuPos) || cpupositons.contains(cpuPos)){
                cpuPos =random.nextInt(9) + 1;
            }
            placePiece(board, cpuPos, "cpu");

            //here we are print board
            printBoard(board);
            
            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
            
            System.out.println(result);
        }
    }
}
