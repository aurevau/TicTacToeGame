public class SmallBoard extends GameBoard {


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
    public void printBoard() {
        int columns = 3;
        String line = "|---+---+---|";
        System.out.println(line);

        for (int i = 0; i < board.length; i++) {
            String cell = board[i];

            if (cell.equals(" ")){
                cell = String.valueOf(i + 1);
            }
//            System.out.print("| " + board[i] +  "  ");
            System.out.print("| " + cell +  " ");
            if ((i + 1) % columns == 0) {
                System.out.println("|");
                System.out.println(line);
            }
        }
    }



    @Override
    public String checkWinner() {
        if (!board[0].equals(" ") && board[0].equals(board[1]) && board[1].equals(board[2])) {
            return board[0];
        }
        if (!board[3].equals(" ") && board[3].equals(board[4]) && board[4].equals(board[5])) {
            return board[3];
        }
        if (!board[6].equals(" ") && board[6].equals(board[7]) && board[7].equals(board[8])) {
            return board[6];
        }

        if (!board[0].equals(" ") && board[0].equals(board[3]) && board[3].equals(board[6])) {
            return board[0];
        }

        if (!board[1].equals(" ") && board[1].equals(board[4]) && board[4].equals(board[7])) {
            return board[1];
        }

        if (!board[2].equals(" ") && board[2].equals(board[5]) && board[5].equals(board[8])) {
            return board[2];
        }

        if (!board[0].equals(" ") && board[0].equals(board[4]) && board[4].equals(board[8])) {
            return board[0];
        }

        if (!board[2].equals(" ") && board[2].equals(board[4]) && board[4].equals(board[6])) {
            return board[2];
        }

        boolean draw = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(" ")) {
                draw = false;
                break;
            }

        }

        if (draw) {
            return "draw!";

        }
        return " ";
    }

    @Override
    public void setMove(int index, String symbol) {
            board[index] = symbol;

    }

    @Override
    public int findWinningMove(String symbol) {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] pattern : winPatterns) {
            int count = 0;
            int emptyIndex = -1;

            for (int i : pattern) {
                if (board[i].equalsIgnoreCase(symbol)) {
                    count++;
                } else if (board[i].equals(" ") && emptyIndex == -1) {
                    emptyIndex = i; // spara första tomma
                }
            }

            if (count == 2 && emptyIndex != -1) {
                return emptyIndex; // returnera vinnande ruta
            }
        }

        return -1; // ingen vinnande ruta
    }

}
