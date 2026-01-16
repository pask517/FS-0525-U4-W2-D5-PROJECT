package andrea.entities;

import andrea.enums.Genre;
import andrea.enums.Platform;

public class VideoGame extends Game {
    private Platform platform;
    private double duration;
    private Genre genre;

    public VideoGame(String title, int publicationYear, int price, Platform platform, double duration, Genre genre) {
        super(title, publicationYear, price);
        if (publicationYear < 1900) {
            throw new IllegalArgumentException("Io non credo tu abbia un gioco del " + publicationYear);
        }
        this.platform = platform;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Videogame{" + super.toString() + ", platform=" + platform + ", duration=" + duration + ", genre=" + genre + "}";
    }
}
