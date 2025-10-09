public class LargeBoard extends GameBoard {
    private int[][] winPatterns = {
            {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},
            {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24},
            {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20}

    };

    public LargeBoard() {
        createBoard();
    }

    public int getColumns() {
        return 5;
    }


    public String getLine() {
        return "|----+----+----+----+----|";
    }

    public int[] getCenterCells() {
        return new int[]{12};
    }

    @Override
    public int[][] getWinningPatterns() {
        return winPatterns;
    }

    @Override
    public int getSize() {
        return board.length;
    }

    @Override
    public String getCell(int index) {
        if (index < 0 || index >= board.length) {
            throw new IllegalArgumentException("index out of bounds" + index);
        }
        return board[index];
    }

    @Override
    public void createBoard() {
        board = new String[25];
        for (int i = 0; i < board.length; i++) {
            board[i] = " ";
        }
    }


    @Override
    public void setMove(int index, String symbol) {
        board[index] = symbol;


    }

}
