package andrea.entities;

import java.time.Year;

public abstract class Game {
    private static long contatoreId = 1;
    private long id;
    private String title;
    private int publicationYear;
    private double price;

    public Game(String title, int publicationYear, double price) {
        this.title = title;

        if (publicationYear < 1900) {
            throw new IllegalArgumentException("Io non credo tu abbia un gioco del " + publicationYear);
        } else if (publicationYear > Year.now().getValue()) {
            throw new IllegalArgumentException("Non puó essere stato pubblicato nel futuro");
        }
        this.publicationYear = publicationYear;
        if (price < 0) {
            throw new IllegalArgumentException("Il prezzo non puó essere negativo");
        }
        this.price = price;
        this.id = contatoreId;
        contatoreId++;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", title='" + title + '\'' +
                        ", publicationYear=" + publicationYear +
                        ", price=" + price;
    }
}
