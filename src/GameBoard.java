public abstract class GameBoard {
    protected String[] board;

    public abstract int getSize();
    public abstract String getCell(int index);
    public abstract void createBoard();
    public abstract void printBoard();

    public abstract String checkWinner();



    public boolean checkMove(int index, String symbol){
        if (index < 0 || index >= board.length) {
            System.out.println("Invalid input, choose a number between 1 - " + board.length);
            return false;
        }
        if (!board[index].isEmpty()) {
            System.out.println("Slot is already filled, try again!");
            return false;
        } return true;
    }


    public void setMove(int index, String symbol) {
        board[index] = symbol;

    }

    public abstract int findWinningMove(String symbol);

}
