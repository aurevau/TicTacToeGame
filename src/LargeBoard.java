public class LargeBoard extends GameBoard {

    public LargeBoard() {
        createBoard();
    }

    public int getColumns(){
        return 5;
    }


    public String getLine(){
        return "|----+----+----+----+----|";
    }

    public int []getCenterCells(){
        return new int[]{12};
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
    board = new String[25];
    for (int i = 0; i < board.length; i++) {
        board[i] = " ";
        }
    }

    @Override
    public void printBoard() {
        int columns = 5;
        String line = "|---+---+---+---+---|";
        System.out.println(line);

    for(int i = 0; i < board.length; i++) {
//        String cell = board[i];
//
//        if(cell.equals(" ")){
//            cell = String.valueOf(i + 1);
//            int number = i +1;
//            if (number >= 10 && number <= 25) {
//                cell = String.valueOf(number);
//            } else {
//                cell = " " + number;
//            }
//        }
//        System.out.print("|" + cell + " ");
        System.out.print("| " + board[i] +  " ");

        if ((i + 1) % 5 == 0) {
            System.out.println("|");
            System.out.println(line);
        }
    }
    }



    @Override
    public String checkWinner() {
        int[][] winPatterns = {
                {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},
                {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24},
                {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20}

        };

        for (int[] pattern : winPatterns) { // Plockar ut en pattern-rad i taget
            String first = board[pattern[0]]; // Hämtar ut vad som finns i första cellen i tictace x o eller ""
            if (!first.equals(" ") &&
                    first.equals(board[pattern[1]]) &&
                    first.equals(board[pattern[2]]) &&
                    first.equals(board[pattern[3]]) &&
                    first.equals(board[pattern[4]])){
                return first;
            }
        }
        boolean draw = true;
        for (String cell : board) {
            if (cell.equals(" ")) {
                draw = false;
                break;
            }
        }
        if (draw) return "draw!";
        return " ";
    }

    @Override
    public void setMove(int index, String symbol) {
        board[index] = symbol;


    }

    @Override
    public int findWinningMove(String symbol) {
        int[][] winPatterns = {
                {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},
                {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24},
                {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20}
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

            if (count == 4 && emptyIndex != -1) {
                return emptyIndex; // returnera vinnande ruta
            }
        }

        return -1; // ingen vinnande ruta
    }


}
