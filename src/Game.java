import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Player p1;
    private Player p2;
    private Player currentPlayer = p1;
    private Player opponent;
    List<Player> players = new ArrayList<>();
    private boolean running = true;
    private GameBoard board;


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
        chooseOpponent();
        setTurns();
        getinput();



    }

    public void chooseGame(){
        System.out.println("Choose Game board size: ");
        System.out.println("1. 3 x 3 ");
        System.out.println("2. 4 x 4 ");
        System.out.println("3. 5 x 5 ");

        int choice = InputHandler.getInt();
        switch(choice){
            case 1: board = new SmallBoard();
            break;
//            case 2: board = new MediumBoard();
//            break;
//            case 3: board = new LargeBoard();
//            break;
        }
    }

    public void chooseOpponent(){
        System.out.println("Do you want to play against a friend or the computer?");
        System.out.println("1. Against a friend");
        System.out.println("2. Against a computer");
        System.out.println("3. Quit Game");


        int choice = InputHandler.getInt();

        switch(choice){
            case 1: createPlayers(2);
            break;
            case 2: createPlayers(1);
            break;
            case 3:
                System.out.println("Welcome Back!");
                System.exit(0);
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
                board.printBoard();
                inputNumber = InputHandler.getInt();
            }
            takeTurns();

            if (!board.setMove(inputNumber - 1, currentPlayer.getSymbol())){
                System.out.println("Invalid input!");


                    if (board.checkWinner().equals("Winner")) {
                        board.printBoard();

                            System.out.println("Press Enter to play again!(quit to quit game)");
                            if(InputHandler.getString().equalsIgnoreCase("quit")) {
                                break;
                            }
                            board.printBoard();
                            board.createBoard();



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
            players.get(0).setSymbol(InputHandler.getString());
            currentPlayer = players.get(0);


            if (players.get(0).getSymbol().equalsIgnoreCase("X")) {
                players.get(0).setSymbol("X");
                players.get(1).setSymbol("O");

                break;

            } else if (players.get(0).getSymbol().equalsIgnoreCase("O")) {
                players.get(0).setSymbol("0");
                players.get(1).setSymbol("X");
                break;

            } else {
                System.out.println("Invalid choice, try again!");
            }

        }
        opponent = players.get(1);
        System.out.println("These are your weapons: ");
        System.out.println(players.get(0).getName() + " : " + players.get(0).getSymbol());
        System.out.println(players.get(1).getName() + ": " + players.get(1).getSymbol());

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


    public void printScore(){
        System.out.println(p1.getName() + " | " + p2.getName() + " | ");
        System.out.println("Wins   | " + p1.getWins() + "  |  " + p2.getWins() + " | ");
        System.out.println("Losses | " + p1.getLosses() + "  | " + p2.getLosses() + "  | ");
        System.out.println("Draws  | " + p1.getDraws() + "  |  " + p2.getDraws() + " | ");

    }
}
