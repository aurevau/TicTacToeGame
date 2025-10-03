public abstract class GameBoard {
    public abstract int getSize();
    public abstract void createBoard();
    public abstract void printBoard();
    public abstract String checkWinner();
    public abstract boolean setMove(int index, String symbol);
}
