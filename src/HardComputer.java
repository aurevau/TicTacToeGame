import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HardComputer implements ComputerPlayer {
    private Random rng = new Random();
    private GameBoard board;

    public HardComputer(GameBoard board) {
        this.board = board;
    }

    @Override
    public int computerChoice(String mySymbol, String opponentSymbol) {
        int winningMove = board.findWinningMove(mySymbol);

        if (winningMove != -1 && board.checkMove(winningMove, mySymbol)) {
            System.out.println();
            return winningMove;
        }

        int blockMove = board.findWinningMove(opponentSymbol);
        if (blockMove != -1 && board.checkMove(blockMove, mySymbol)) {
            return blockMove;
        }

        int[] centerCells = board.getCenterCells();
        List<Integer> availableMoves = new ArrayList<>();
        for (int index : centerCells) {
            if (board.checkMove(index, mySymbol)) {
                availableMoves.add(index);
            }
        }

        if (!availableMoves.isEmpty()) {
            return availableMoves.get(rng.nextInt(availableMoves.size()));

        }

        int choice;
        do {
            choice = rng.nextInt(board.getSize());
        } while (!board.checkMove(choice, mySymbol));
        return choice;
    }
}
