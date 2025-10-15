package Computers;

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
        if (winningMove != -1 && board.checkMove(winningMove, mySymbol)) {
            return winningMove;
        }

        int choice;
        do {
            choice = rng.nextInt(board.getSize());

        } while (!board.checkMove(choice, mySymbol));
        return choice;


    }

}
