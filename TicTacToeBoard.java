import java.util.Random;
import java.util.Scanner;

public class TicTacToeBoard {

    private char[][] board = new char[3][3];
    private String line;

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    private static TicTacToeBoard ticTacToeBoard;

    private TicTacToeBoard() {
        for (int i = 0; board.length > i; i += 1) {
            for (int j = 0; board[i].length > j; j += 1) {
                board[i][j] = '_';
            }
        }

    }

    public static TicTacToeBoard getInstance() {
        if (ticTacToeBoard == null) {
            ticTacToeBoard = new TicTacToeBoard();
        }

        return ticTacToeBoard;
    }

    public void printBoard() {
        for (char[] cs : board) {
            for (int i = 0; cs.length > i; i += 1) {

            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
    
    public boolean playAgainstComputer() {
        String computerOrPlayer;
        do {
        System.out.println("Would you like to play against a player or computer? Type \"Player\" or \"Computer\"");
        computerOrPlayer = input.nextLine().toLowerCase();

        if(computerOrPlayer.equals("player")) {
            return true;
        } else if(computerOrPlayer.equals("computer")) {
            return false;
        } else {
            System.out.println("Invalid Response! Please try again");
            continue;
        } } while(!computerOrPlayer.equals("player") || !computerOrPlayer.equals("computer"));
        return false;
    }

    public void playCPU() {
        boolean notValid = true;
        int xPos;
        int yPos;

        do { 
            xPos = random.nextInt(3);
            yPos = random.nextInt(3);

            if (board[xPos][yPos] == '_') {
                board[xPos][yPos] = 'O';
                notValid = false;
            } else {
                System.out.println("spot taken");
            }
        } while (notValid);
    }

    public void playX() {
        boolean notValid = true;
        int xPos;
        int yPos;
        do {
            System.out.println("What Row? 1-3");
            xPos = clamp(input.nextInt(), 1, 3) - 1;
            System.out.println("What Column? 1-3");
            yPos = clamp(input.nextInt(), 1, 3) - 1;

            if (board[xPos][yPos] == '_') {
                board[xPos][yPos] = 'X';
                notValid = false;
            } else {
                System.out.println("That spot is already taken");
            }

        } while (notValid);

    }

    public void playO() {
        boolean notValid = true;
        int xPos;
        int yPos;

        do {
            System.out.println("What Row? 1-3");
            xPos = clamp(input.nextInt(), 1, 3) - 1;
            System.out.println("What Column? 1-3");
            yPos = clamp(input.nextInt(), 1, 3) - 1;

            if (board[xPos][yPos] == '_') {
                board[xPos][yPos] = 'O';
                notValid = false;
            } else {
                System.out.println("That spot is already taken");
            }
        } while (notValid);
    }

    public String checkWinner() {
        for (int i = 0; i < 8; i++) {
            line = null;
            switch (i) {
                case 0:
                    line = "" + board[0][0] + board[0][1] + board[0][2];
                    break;
                case 1:
                    line = "" + board[1][0] + board[1][1] + board[1][2];
                    break;
                case 2:
                    line = "" + board[2][0] + board[2][1] + board[2][2];
                    break;
                case 3:
                    line = "" + board[0][0] + board[1][0] + board[2][0];
                    break;
                case 4:
                    line = "" + board[0][1] + board[1][1] + board[2][1];
                    break;
                case 5:
                    line = "" + board[0][2] + board[1][2] + board[2][2];
                    break;
                case 6:
                    line = "" + board[0][0] + board[1][1] + board[2][2];
                    break;
                case 7:
                    line = "" + board[0][2] + board[1][1] + board[2][0];
                    break;
            }

            // System.out.println("Line: " + line);
            if (line.equals("XXX")) {
                return "Player X won";
            } else if (line.equals("OOO")) {
                return "Player O won";
            }
        }
        return null;
    }

    private int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}