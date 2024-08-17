public class App {

    private static int turnOrder;
    private static String winner;
    public static void main(String Args[]){
        TicTacToeBoard board = TicTacToeBoard.getInstance();
        turnOrder = 0;
        do{
            board.printBoard();
            if(turnOrder % 2 == 0){
                board.playX();
            } else {
                board.playO();
            }
            turnOrder += 1;
            winner = board.checkWinner();
        }while(winner == null || turnOrder < 9);

    }
}