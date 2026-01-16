package andrea;

import andrea.entities.Genre;
import andrea.entities.Platform;
import andrea.entities.VideoGame;

public class Application {

    public static void main(String[] args) {
        VideoGame ciao = new VideoGame("Ciao", 1900, 50, Platform.PS5, 5.5, Genre.FPS);

    }
}
