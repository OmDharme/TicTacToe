import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        char[] board = new char[10];
        Arrays.fill(board, ' ');

        System.out.println("Player 1, what do you want X or O?");
        char mark1 = sc.next().charAt(0);
        char mark2 = (mark1 == 'X') ? 'O' : 'X';

        printBoard(board);

        boolean win = false;
        int player = 1;
        char mark = mark1;
        int moves = 0;

        while(!win){
            moves++;
            System.out.println("Player " + player + "s turn");

            int position = playerChoice(board);
            placeMark(board, position, mark);
            printBoard(board);

            win = winCheck(board, mark);
            if(!win) {
                player = (player==1) ? 2 : 1;
                mark = (mark==mark1) ? mark2 : mark1;
            }else{
                System.out.println("Player " + player + "wins");
            }

            if(moves==9){
                System.out.println("Its a draw");
                break;
            }

        }

    }

    public static void printBoard(char[] board){
        System.out.println("   |   |   ");
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("___|___|___");
        System.out.println("   |   |   ");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("___|___|___");
        System.out.println("   |   |   ");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
        System.out.println("   |   |   ");
    }

    public static int playerChoice(char[] board){
        while(true){
            int position = sc.nextInt();
            if(choicePossible(board, position)) return position;
            else {
                System.out.println("Position already taken, take another");
                continue;
            }
        }
    }

    public static void placeMark(char[] board, int position, char mark){
        board[position] = mark;
    }

    public static boolean winCheck(char[] board, char mark){
        if(board[1] == board[2] && board[2] == board[3] && board[3] == mark) return true;
        else if(board[4] == board[5] && board[5] == board[6] && board[6] == mark) return true;
        else if(board[7] == board[8] && board[8] == board[9] && board[9] == mark) return true;
        else if(board[1] == board[4] && board[4] == board[7] && board[7] == mark) return true;
        else if(board[2] == board[5] && board[5] == board[8] && board[8] == mark) return true;
        else if(board[3] == board[6] && board[6] == board[9] && board[9] == mark) return true;
        else if(board[1] == board[5] && board[5] == board[9] && board[9] == mark) return true;
        else if(board[3] == board[5] && board[5] == board[7] && board[7] == mark) return true;
        else return false;
    }

    public static boolean choicePossible(char[] board, int position){
        if(board[position] == ' ') return true;
        return false;
    }




}
