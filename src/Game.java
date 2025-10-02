import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Player p1;
    private Player p2;
    private Player currentPlayer = p1;
    private Player opponent;
    List<Player> players = new ArrayList<>();

    static String[] board;
    public Game() {
        run();



    }

    public int computerChoice(){
        Random rng = new Random();
        int computerChoice = rng.nextInt(9) + 1;
        return computerChoice;
    }
    public void run(){
        System.out.println("Welcome to Tic Tac Toe!");
        chooseGame();
        setTurns();
        createBoard();

        getinput();


    }

    public void chooseGame(){
        System.out.println("Do you want to play against a friend or the computer?");
        System.out.println("1. Against a friend");
        System.out.println("2. Against a computer");

        int choice = InputHandler.getInt();

        switch(choice){
            case 1: createPlayers(2);
            break;
            case 2: createPlayers(1);
            break;
        }
    }

    public void getinput() {

        while (true) {

            int inputNumber;

            if (currentPlayer.getName().equals("Computer")){
                inputNumber = computerChoice();
                System.out.println("Computer chooses " + (inputNumber));
            } else {
                System.out.println(currentPlayer.getName() + " choose where to put your mark(1-9): ");
                printBoard();
                inputNumber = InputHandler.getInt();
            }

            if (inputNumber < 1 || inputNumber > 9) {
                System.out.println("Invalid input!");

            } else {
                    if (board[inputNumber - 1].equalsIgnoreCase("")) {
                        board[inputNumber - 1] = currentPlayer.getTurn();
                        printBoard();
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
        if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
        } else if (currentPlayer == players.get(1)) {
            currentPlayer = players.get(0);
        }
    }

    public void setTurns() {

        while (true) {
            System.out.println("Player 1, choose your weapon: 'x' or 'o'");
            players.get(0).setTurn(InputHandler.getString());
            currentPlayer = players.get(0);


            if (players.get(0).getTurn().equalsIgnoreCase("X")) {
                players.get(1).setTurn("O");

                break;

            } else if (players.get(0).getTurn().equalsIgnoreCase("O")) {
                players.get(1).setTurn("X");
                break;

            } else {
                System.out.println("Invalid choice, try again!");
            }

        }
        opponent = players.get(1);
        System.out.println("These are your weapons: ");
        System.out.println(players.get(0).getName() + " : " + players.get(0).getTurn());
        System.out.println(players.get(1).getName() + ": " + players.get(1).getTurn());

    }

    public void createPlayers(int playerNumber){
        for (int i = 0; i < playerNumber; i++){
            while(true){
                System.out.println("Player " + (i + 1) + ", choose your name: ");
                String name = InputHandler.getString();

                boolean duplicate = false;
                for (Player p : players){
                    if (p.getName().equalsIgnoreCase(name)){
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate){
                    System.out.println("Name already exsists, try again!");
                } else{
                    players.add(new Player(name));
                    break;
                }


            }
        }
        p1 = players.get(0);
        if (playerNumber > 1) {
            p2 = players.get(1);
        } else {
            p2 = new Player("Computer");
            players.add(p2);
            System.out.println("Player 2 is the " + players.get(1).getName());


        }

        currentPlayer = p1;
        opponent = p2;
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
