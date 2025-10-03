public class SmallBoard extends GameBoard {
    private String[] board;

    public SmallBoard() {
        createBoard();
    }

    @Override
    public void createBoard() {
        board = new String[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = "";
        }
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(" [ " + board[i] + " ] ");

            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    @Override
    public String checkWinner() {
        if (!board[0].equals("") && board[0].equals(board[1]) && board[1].equals(board[2])) {
            return board[0];
        }
        if (!board[3].equals("") && board[3].equals(board[4]) && board[4].equals(board[5])) {
            return board[3];
        }
        if (!board[6].equals("") && board[6].equals(board[7]) && board[7].equals(board[8])) {
            return board[6];
        }

        if (!board[0].equals("") && board[0].equals(board[3]) && board[3].equals(board[6])) {
            return board[0];
        }

        if (!board[1].equals("") && board[1].equals(board[4]) && board[4].equals(board[7])) {
            return board[1];
        }

        if (!board[2].equals("") && board[2].equals(board[5]) && board[5].equals(board[8])) {
            return board[2];
        }

        if (!board[0].equals("") && board[0].equals(board[4]) && board[4].equals(board[8])) {
            return board[0];
        }

        if (!board[2].equals("") && board[2].equals(board[4]) && board[4].equals(board[6])) {
            return board[2];
        }

        boolean draw = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("")) {
                draw = false;
                break;
            }

        }

        if (draw) {
            return "draw!";

        }
        return "";
    }


    @Override
    public boolean setMove(int index, String symbol) {

        if (index < 0 || index >= 9) {
            System.out.println("Invalid input, choose a number between 1-9");
            return false;
        }
        if (!board[index].isEmpty()) {
            System.out.println("Slot is already filled, try again!");
            return false;
        }
        // Sets move
        board[index -1] = symbol;
        return true;
    }
}
