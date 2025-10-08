import java.util.Random;

public class MediumComputer implements ComputerPlayer {
    private Random rng = new Random();
    private GameBoard board;

    public MediumComputer(GameBoard board) {
        this.board = board;
    }

    @Override
    public int computerChoice(String mySymbol, String opponentSymbol) {
        int winningMove = board.findWinningMove(mySymbol);
        if (winningMove != -1) {
            return winningMove;
        }

//        int blockMove = board.findWinningMove(opponentSymbol);
//        if (blockMove != -1 && board.checkMove(blockMove, mySymbol))  {
//            return blockMove;
//        }


        int choice;
        choice = rng.nextInt(board.getSize());
        return choice;


        }

}
