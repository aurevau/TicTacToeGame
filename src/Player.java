public class Player {

    private String name;
    private int wins;
    private int losses;
    private int draws;
    private String symbol;
    private Player opponent;

    public Player(String name) {
        this.name = name;
    }

    public int getLosses() {
        return losses;
    }

    public void addLosses() {
        losses++;
    }

    public int getDraws() {
        return draws;
    }

    public void addDraws() {
        draws++;
    }



    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void addWins() {
        wins++;
    }
}
