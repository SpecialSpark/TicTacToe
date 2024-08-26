public class App {

    private static int turnOrder;
    private static String winner;

    public static void main(String Args[]) {
        TicTacToeBoard board = TicTacToeBoard.getInstance();
        boolean whoToPlay = board.playAgainstComputer();

        if (whoToPlay) {
            turnOrder = 0;
            do {
                board.printBoard();
                if (turnOrder % 2 == 0) {
                    board.playX();
                } else {
                    board.playO();
                }
                turnOrder += 1;
                winner = board.checkWinner();
            } while (winner == null && turnOrder < 9);
        } else {
            do {
                if (turnOrder % 2 == 0) {
                    board.printBoard();
                    board.playX();
                } else {
                    board.playCPU();
                }
                turnOrder += 1;
                winner = board.checkWinner();
            } while (winner == null && turnOrder < 9);
        }
        System.out.println(winner);
        board.printBoard();
    }
}