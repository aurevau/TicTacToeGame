public class Game {
    private Player p1;
    private Player p2;
    private Player currentPlayer = p1;

    static String[] board;
    public Game() {
        run();



    }
    public void run(){
        System.out.println("Welcome to Tic Tac Toe!");
        createBoard();
        createPlayers();
        setTurns();
        getinput();


    }

    public void getinput() {

        while (true) {
            System.out.println("Choose where to put your mark(1-9): ");
            printBoard();
            int inputNumber = InputHandler.getInt();


            if (inputNumber < 1 || inputNumber > 9) {
                System.out.println("Invalid input!");

            } else {
                    if (board[inputNumber - 1].equalsIgnoreCase("")) {
                        board[inputNumber - 1] = currentPlayer.getTurn();
                        if(checkWinner()) {
                            System.out.println("Press Enter to play again!");
                            InputHandler.getString();
                            printBoard();
                        }
                        takeTurns();

                    } else {
                        System.out.println("Slot is filled, try again!");
                    }
                }
        }
    }
    public void takeTurns(){
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else if (currentPlayer == p2) {
            currentPlayer = p1;
        }
    }

    public void setTurns() {

        while (true) {
            System.out.println("Player 1, choose your weapon: 'x' or 'o'");
            p1.setTurn(InputHandler.getString());
            currentPlayer = p1;

            if (p1.getTurn().equalsIgnoreCase("X")) {
                p2.setTurn("O");

                break;

            } else if (p1.getTurn().equalsIgnoreCase("O")) {
                p2.setTurn("X");
                break;

            } else {
                System.out.println("Invalid choice, try again!");
            }

        }
        System.out.println("These are your weapons: ");
        System.out.println("Player 1: " + p1.getTurn());
        System.out.println("Player 2: " + p2.getTurn());

    }
    public void createPlayers() {
        System.out.println("Player 1, choose your name: ");
        String name1 = InputHandler.getString();
        p1 = new Player(name1);

        while (true) {
            System.out.println("Player 2, choose your name: ");
            String name2 = InputHandler.getString();

            if (name1.equalsIgnoreCase(name2)) {
                System.out.println("Name already exists, try again!");

            } else {
                p2 = new Player(name2);
                break;
            }
        }
    }
    public void createBoard(){
        board = new String[9];
        for(int i = 0; i < board.length; i++){
            board[i] = "";
        }



    }
    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            System.out.print("[" + board[i] + "]");

            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public boolean checkWinner(){
        if (!board[0].equals("") && board[0].equals(board[1]) && board[1].equals(board[2])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }
        if(!board[3].equals("") && board[3].equals(board[4]) && board[4].equals(board[5])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }
        if (!board[6].equals("") && board[6].equals(board[7]) && board[7].equals(board[8])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }

        if (!board[0].equals("") && board[0].equals(board[3]) && board[3].equals(board[6])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }

        if(!board[1].equals("") && board[1].equals(board[4]) && board[4].equals(board[7])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }

        if (!board[2].equals("") && board[2].equals(board[5]) && board[5].equals(board[8])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }

        if (!board[0].equals("") && board[0].equals(board[4]) && board[4].equals(board[8])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }

        if (!board[2].equals("") && board[2].equals(board[4]) && board[4].equals(board[6])) {
            System.out.println("Winner is " + currentPlayer.getName());
            return true;
        }

        boolean draw = true;

        for(int i = 0; i < board.length; i++){
            if(!board[i].equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            System.out.println("It's a draw!");

        } return false;
    }

}
