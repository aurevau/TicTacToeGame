public abstract class GameBoard {
    protected String[] board;

    public abstract int getSize();
    public abstract String getCell(int index);
    public abstract void createBoard();
    public abstract String getLine();
    public abstract int getColumns();
//    public abstract String checkWinner();
    public abstract void setMove(int index, String symbol);
//    public abstract int findWinningMove(String symbol);
    public abstract int[] getCenterCells();
    public abstract int[][] getWinningPatterns();

    public String getRules(){
        return " RULES" +
                "\n - To win this game, you have to get " + getColumns() + " symbols in a row; diagonal, horizontal or vertical." +
                "\n - You and your opponent take turns placing your symbols" +
                "\n - You can quit the game by writing 'quit' or -1" +
                "\n Press Enter to continue";
    }

    public String checkWinner(){
        int[][] winPatterns = getWinningPatterns();

        for (int[] pattern : winPatterns){
            String first = board[pattern[0]];
            if (!first.equals(" ")){
                boolean allMatch = true;
                for (int i = 1; i < pattern.length; i++){
                    if (!board[pattern[i]].equals(first)){
                        allMatch = false;
                        break;
                    }
                }
                if (allMatch){
                    return first;
                }
            }
        }

        for (String cell : board) {
            if (cell.equals(" ")){
                return " ";
            }
        }
        return "draw!";
    }

    public int findWinningMove(String symbol){
        for (int [] pattern : getWinningPatterns()) {
            int count = 0;
            int emptyIndex = -1;

            for (int i : pattern) {
                if (board[i].equalsIgnoreCase(symbol)) {
                    count++;
                } else if (board[i].equals(" ") && emptyIndex == -1) {
                    emptyIndex = i;
                }
            } // Försök vinna om möjligt
            if (count == getColumns() - 1 && emptyIndex != -1) {
                return emptyIndex;
            }
        }
        return -1;
    }


    public void printAnotherBoard(){
        System.out.println(getLine());
        for (int i = 0; i < board.length; i++){

            String cell = board[i];
            if (cell.equals(" ")) {
                int number = i + 1;
                // Alla celler får 2 tecken breda, högerjusterade
                cell = String.format("%2d", number);
            } else {
                // X eller O får också 2 tecken, så att brädet blir jämnt
                cell = String.format(" %s", cell);
            }

            System.out.print("| " + cell + " ");
//            System.out.print("| " + board[i] + " ");
            if ((i + 1) % getColumns() == 0) {
                System.out.println("|");
                System.out.println(getLine());
            }
        }
    }



    public boolean checkMove(int index, String symbol){

        if (index < 0 || index >= board.length) {
            System.out.println("Invalid input, choose a number between 1 - " + board.length);
            return false;
        }
        if (!board[index].equals(" ")) {
            return false;
        } return true;
    }



}
