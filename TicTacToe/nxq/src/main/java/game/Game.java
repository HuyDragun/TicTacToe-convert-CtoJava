package game;
import java.util.Scanner;

public class Game {
    public Game() {
    }
    static char board[][] = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
    //static char board[][] =  new char[3][3];
    static int size = 3;
    static int player = 1;
    static boolean isGameOver = false;
    static boolean isTie = false;
    static Scanner sc = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBoard() {
        clearScreen();
        System.out.println("Game TicTacToe Java");
        System.out.println("PLAYER 1 - [X] \t PLAYER 2 = [0]");
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("| ");
            System.out.println("-------------");
        }
    }

    public static void update() {
        char mark;
        player = (player % 2 == 1) ? 1 : 2;
        mark = (player == 1) ? 'X' : 'O';
        int p;
        do {
            System.out.println("Player " + player + ", please input position you choice (X - Y): ");
            p = sc.nextInt();
        }while(p < 0 || p > 10 ||!position(p, mark));
            player++;    
    }

    public static boolean position(final int position, final char mark) {
        int x = 0, y = 0;
        switch(position){
            case 1: x = 0; y=0; break;
            case 2: x = 0; y=1; break;
            case 3: x = 0; y=2; break;
            case 4: x = 1; y=0; break;
            case 5: x = 1; y=1; break;
            case 6: x = 1; y=2; break;
            case 7: x = 2; y=0; break;
            case 8: x = 2; y=1; break;
            case 9: x = 2; y=2; break;
            default:            break;
        }
        if(board[x][y]==' ') {
            board[x][y] = mark;
            return true;
        }
        return false;
    }
    
    public static boolean checkBoard(){
        if (board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][1] == board[0][2])
            return true;
        else if (board[1][0] != ' ' && board[1][0] == board[1][1] && board[1][1] == board[1][2])
            return true;
        else if (board[2][0] != ' ' && board[2][0] == board[2][1] && board[2][1] == board[2][2])
            return true;
        else if (board[0][0] != ' ' && board[0][0] == board[1][0] && board[1][0] == board[2][0])
            return true;
        else if (board[0][1] != ' ' && board[0][1] == board[1][1] && board[1][1] == board[2][1])
            return true;
        else if (board[0][2] != ' ' && board[0][2] == board[1][2] && board[1][2] == board[2][2])
            return true;
        else if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;
        else if (board[0][0] != ' ' && board[0][1] != ' ' && board[0][2] != ' ' &&
                board[1][0] != ' ' && board[1][1] != ' ' && board[1][2] != ' ' &&
                board[2][0] != ' ' && board[2][1] != ' ' && board[2][2] != ' ')
            {
                isTie = true;
                return true;
            }
        return false;
    }

    public static boolean isGameOver(){
        isGameOver = checkBoard();
        if(isGameOver){
            printBoard();
            if (isTie)
                System.out.println("-----Both players are tie-----");
            else 
                System.out.println("-----Player " + --player + " is winner-----");
        }
        return isGameOver;
    }
    
    /*public static void main(String[] args) {
        System.out.println("Game TicTacToe Java");
        System.out.println("PLAYER 1 - [X] \t PLAYER 2 = [0]");   
        while (!isGameOver){
            System.out.println("Game TicTacToe Java");
            System.out.println("PLAYER 1 - [X] \t PLAYER 2 = [0]");   
            printBoard();
            update();
            clearScreen();    
        }
    }*/
}
