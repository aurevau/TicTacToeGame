public class MediumBoard extends GameBoard {


    public MediumBoard() {
        createBoard();
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
        int[][] winPatterns = {
                {0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15},
                {0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15},
                {0, 5, 10, 15}, {3, 6, 9, 12}
        };

        for (int[] pattern : winPatterns) { // Plockar ut en pattern-rad i taget
            String first = board[pattern[0]]; // Hämtar ut vad som finns i första cellen i tictace x o eller ""
            if (!first.equals("") &&
                    first.equals(board[pattern[1]]) &&
                    first.equals(board[pattern[2]]) &&
                    first.equals(board[pattern[3]])) {
                return first;
            }
        }
        boolean draw = true;
        for (String cell : board) {
            if (cell.equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) return "draw";
        return "";
    }

    @Override
    public int findWinningMove(String symbol) {
        int[][] winPatterns = {
                {0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15},
                {0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15},
                {0, 5, 10, 15}, {3, 6, 9, 12}
        };

        for (int[] pattern : winPatterns) {
            int count = 0;
            int emptyIndex = -1;

            for (int i : pattern) {
                if (board[i].equals(symbol)) {
                    count++;
                } else if (board[i].isEmpty() && emptyIndex == -1) {
                    emptyIndex = i; // spara första tomma
                }
            }

            if (count == 3 && emptyIndex != -1) {
                return emptyIndex; // returnera vinnande ruta
            }
        }

        return -1; // ingen vinnande ruta
    }

}

