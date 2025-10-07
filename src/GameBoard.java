public abstract class GameBoard {
    protected String[] board;

    public abstract int getSize();
    public abstract String getCell(int index);
    public abstract void createBoard();
    public abstract void printBoard();
    public abstract String getLine();
    public abstract int getColumns();

    public abstract String checkWinner();


    public void printAnotherBoard(){
        Game.clearScreen();
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
            System.out.println("Slot is already filled, try again!");
            return false;
        } return true;
    }


    public abstract void setMove(int index, String symbol);

    public abstract int findWinningMove(String symbol);

    public abstract int[] getCenterCells();
}
