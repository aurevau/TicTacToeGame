public class MediumBoard extends GameBoard {
    private String[] board;

    public MediumBoard() {
        createBoard();
    }

    @Override
    public void createBoard() {
        board = new String[16];
        for (int i = 0; i < board.length; i++){
            board[i] = "";
        }
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < board.length; i++){
            System.out.print(" [ " + board[i] + " ] ");

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }

    @Override
    public String checkWinner() {
        return "";
    }

    @Override
    public boolean setMove(int index, String symbol) {
        return false;
    }
}
