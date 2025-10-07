import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HardComputer implements ComputerPlayer{
    private Random rng = new Random();
    private GameBoard board;
    private boolean lastMoveWasBlock = false;
    public HardComputer(GameBoard board) {
        this.board = board;
    }


    @Override
    public int computerChoice(String mySymbol, String opponentSymbol) {
        int winningMove = board.findWinningMove(mySymbol);

        if (winningMove != -1 && board.checkMove(winningMove, mySymbol)) {
            lastMoveWasBlock = false;
            return winningMove;
        }


        int blockMove = board.findWinningMove(opponentSymbol);
        System.out.println("blockmove: " + blockMove);
        if (blockMove != -1 && board.checkMove(blockMove, mySymbol))  {
            lastMoveWasBlock = true;
            return blockMove;
        }

        lastMoveWasBlock = false;
        int [] centerCells = board.getCenterCells();
        List<Integer> availableMoves = new ArrayList<>();
        for ( int index : centerCells){
            if (board.getCell(index).equals(" ")) {
                availableMoves.add(index);
            }
        }

        int choice;
        if (!availableMoves.isEmpty()) {
            choice = availableMoves.get(rng.nextInt(availableMoves.size()));
            return choice;

        }

        do {
            choice = rng.nextInt(board.getSize());

        } while (!board.checkMove(choice, mySymbol));
        return choice;


    }

    @Override
    public boolean lastMoveWasBlock() {
        return lastMoveWasBlock;
    }

}
