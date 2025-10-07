import java.util.Random;

public class EasyComputer implements ComputerPlayer {
    private Random rng = new Random();
    private GameBoard board;

    public EasyComputer(GameBoard board) {
        this.board = board;
    }

    @Override
    public int computerChoice(String symbol, String opponentSymbol) {
        int choice;
        choice = rng.nextInt(board.getSize());
        return choice;
    }

    @Override
    public boolean lastMoveWasBlock() {
        return false;
    }


}
