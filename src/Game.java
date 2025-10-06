import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player p1;
    private Player p2;
    private Player currentPlayer = p1;
    private Player opponent;
    List<Player> players = new ArrayList<>();
    private GameBoard board;
    private ComputerPlayer cpu;


    public Game() {
        run();




    }



    public void run() {

        System.out.println("Welcome to Tic Tac Toe!");
        chooseGame();
        chooseOpponent();
        setSymbols();
        gameLoop();





    }

    public void gameLoop(){
        boolean gameOver = false;

        while (!gameOver){
            board.printBoard();
            int inputNumber = getInput();
            board.setMove(inputNumber, currentPlayer.getSymbol());
            gameOver = checkInput();

            if (!gameOver) {
                takeTurns();
            }
        }
    }

    public void chooseGame() {
        System.out.println("Choose Game board size: ");
        System.out.println("1. 3 x 3 ");
        System.out.println("2. 4 x 4 ");
        System.out.println("3. 5 x 5 ");

        int choice = InputHandler.getInt();
        switch (choice) {
            case 1:
                board = new SmallBoard();
                break;
            case 2: board = new MediumBoard();
            break;
            case 3: board = new LargeBoard();
            break;
            default:
                System.out.println("Invalid choice, try again!");
                chooseGame();
        }
    }

    public void chooseOpponent() {
        System.out.println("Do you want to play against a friend or the computer?");
        System.out.println("1. Against a friend");
        System.out.println("2. Against a computer");
        System.out.println("3. Quit Game");


        int choice = InputHandler.getInt();

        switch (choice) {
            case 1:
                createPlayers(2);
                break;
            case 2:
                createPlayers(1);
                break;
            case 3:
                System.out.println("Welcome Back!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, try again!");
                chooseOpponent();
        }
    }

    public void chooseLevel(){

        System.out.println("Choose level: ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int choice = InputHandler.getInt();

        switch (choice) {
            case 1:
                cpu = new EasyComputer(board);
                System.out.println("You chose easy mode");
                break;
            case 2:
                cpu = new MediumComputer(board);
                System.out.println("You chose medium mode");
                break;
            case 3:
                cpu = new HardComputer(board);
                System.out.println("You chose hard mode");
                break;
            default:
                System.out.println("Invalid choice, try again!");
                chooseLevel();
        }
    }

    public int getInput() {
        int inputNumber = - 1;
        boolean validMove = false;

        while (!validMove) {
            if (currentPlayer.getName().equalsIgnoreCase("COMPUTER")) {
                inputNumber = cpu.computerChoice(p1.getSymbol(), p2.getSymbol());
                validMove = board.checkMove(inputNumber, currentPlayer.getSymbol());
                System.out.println("Computer chooses: " + (inputNumber + 1));
            } else {
                System.out.println(currentPlayer.getName() + "(" + currentPlayer.getSymbol() + "): choose where to put your mark(1-" + board.getSize() + ")" );
                inputNumber = InputHandler.getInt() - 1;
            }

            validMove = board.checkMove(inputNumber, currentPlayer.getSymbol());

            }

        board.setMove(inputNumber, currentPlayer.getSymbol());
        return inputNumber;


    }

    // Check name
    private boolean checkInput() {
            String winner = board.checkWinner();

            if (!winner.equals(" ")) {
                board.printBoard();
                if (winner.equals("draw!")){
                    System.out.println("It's a draw!");
                    currentPlayer.addDraws();
                    opponent.addDraws();
                    printScore();
            } else if (winner.equalsIgnoreCase(currentPlayer.getSymbol())){
                    System.out.println("Winner is " + currentPlayer.getName());
                    currentPlayer.addWins();
                    opponent.addLosses();
                    printScore();
                }

                System.out.println("Press Enter to play again!(quit to quit game)");
                if (InputHandler.getString().equalsIgnoreCase("quit")) {
                    return true;
                }
                board.createBoard();
            }

        return false;
    }


    public void takeTurns() {
        if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
            opponent = players.get(0);
        } else if (currentPlayer == players.get(1)) {
            currentPlayer = players.get(0);
            opponent = players.get(1);
        }
    }

    public void setSymbols() {

        while (true) {
            System.out.println(currentPlayer.getName() + ": choose your weapon: 'x' or 'o'");
            players.get(0).setSymbol(InputHandler.getString());
            currentPlayer = players.get(0);


            if (players.get(0).getSymbol().equalsIgnoreCase("X")) {
                players.get(0).setSymbol("x");
                players.get(1).setSymbol("o");

                break;

            } else if (players.get(0).getSymbol().equalsIgnoreCase("O")) {
                players.get(0).setSymbol("o");
                players.get(1).setSymbol("x");
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

    public void createPlayers(int playerNumber) {
        for (int i = 0; i < playerNumber; i++) {
            while (true) {
                System.out.println("Player " + (i + 1) + ", choose your name: ");
                String name = InputHandler.getName();

                boolean duplicate = false;
                for (Player p : players) {
                    if (p.getName().equalsIgnoreCase(name)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("Name already exsists, try again!");
                } else {
                    players.add(new Player(name));
                    break;
                }
            }
        }

        p1 = players.get(0);
        if (playerNumber == 1) {
            p2 = new Player("COMPUTER");
            players.add(p2);
            System.out.println("Player 2 is the " + players.get(1).getName());
            chooseLevel();

        } else {
            p2 = players.get(1);
        }

        currentPlayer = p1;
        opponent = p2;
    }


    public void printScore() {
        System.out.println("HIGHSCHORE");
        System.out.println("    " + p1.getName() + " | " + p2.getName() + " | ");
        System.out.println("Wins   | " + p1.getWins() + "  |  " + p2.getWins() + " | ");
        System.out.println("Losses | " + p1.getLosses() + "  |  " + p2.getLosses() + " | ");
        System.out.println("Draws  | " + p1.getDraws() + "  |  " + p2.getDraws() + " | ");

    }
}
