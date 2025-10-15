package Boards;

public class MediumBoard extends GameBoard {
    private int[][] winPatterns = {
            {0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15},
            {0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15},
            {0, 5, 10, 15}, {3, 6, 9, 12}
    };

    public MediumBoard() {
        createBoard();
    }

    public String getLine() {
        return "|----+----+----+----|";
    }

    public int getColumns() {
        return 4;
    }


    public int[] getCenterCells() {
        return new int[]{5, 6, 9, 10};
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
        board = new String[16];
        for (int i = 0; i < board.length; i++) {
            board[i] = " ";
        }
    }


    @Override
    public void setMove(int index, String symbol) {
        board[index] = symbol;


    }
}

