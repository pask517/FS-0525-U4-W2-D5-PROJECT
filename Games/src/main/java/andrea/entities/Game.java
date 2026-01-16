package andrea.entities;

public abstract class Game {
    private long contatoreId = 0;
    private long id;
    private String title;
    private int publicationYear;
    private int price;

    public Game(String title, int publicationYear, int price) {
        this.title = title;

        if (publicationYear < 1900) {
            throw new IllegalArgumentException("Io non credo tu abbia un gioco del " + publicationYear);
        }
        this.publicationYear = publicationYear;
        if (price < 0) {
            throw new IllegalArgumentException("Il prezzo non puó essere negativo");
        }
        this.price = price;
        this.id = contatoreId;
        contatoreId++;
    }

}
