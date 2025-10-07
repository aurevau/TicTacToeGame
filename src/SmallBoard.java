public class SmallBoard extends GameBoard {
    private int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };



    public SmallBoard() {
        createBoard();
    }

    public String getLine(){
        return "|----+----+----|";
    }
    public int getColumns(){
        return 3;
    }


    public String[] getBoard() {
        return board;
    }

    public int[] getCenterCells(){
        return new int[]{4};
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
        if (index < 0 ||index >= board.length){
            throw new IllegalArgumentException("index out of bounds" + index);
        }
        return board[index];
    }

    @Override
    public void createBoard() {
        board = new String[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = " ";
        }
    }


    @Override
    public void setMove(int index, String symbol) {
            board[index] = symbol;

    }



}
