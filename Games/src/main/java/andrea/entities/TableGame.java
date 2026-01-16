package andrea.entities;

public class TableGame extends Game {
    private int players;
    private int singleGameDuration;

    public TableGame(String title, int publicationYear, int price, int players, int singleGameDuration) {
        super(title, publicationYear, price);
        if (players < 2 || players > 10) {
            throw new IllegalArgumentException("Numero di giocatori fuori dal range 2-10");
        }
        this.players = players;
        if (singleGameDuration < 0) {
            throw new IllegalArgumentException("La durata non puó essere negativa");
        }
        this.singleGameDuration = singleGameDuration;
    }

    @Override
    public String toString() {
        return "TableGame{" + super.toString() + ", players=" + players + ", singleGameDuration=" + singleGameDuration + "}";
    }

    public int getPlayers() {
        return players;
    }

    public int getSingleGameDuration() {
        return singleGameDuration;
    }
}
