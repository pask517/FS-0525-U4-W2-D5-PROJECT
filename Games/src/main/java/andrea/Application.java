package andrea;

import andrea.entities.Collection;
import andrea.entities.Game;
import andrea.entities.TableGame;
import andrea.entities.VideoGame;
import andrea.enums.Genre;
import andrea.enums.Platform;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VideoGame callOfDuty4 = new VideoGame("Call Of Duty 4", 1978, 65, Platform.PS5, 5.5, Genre.FPS);
        VideoGame halo = new VideoGame("Halo", 1965, 20, Platform.XBOX, 5.5, Genre.FPS);
        VideoGame crysis = new VideoGame("Crysis", 2016, 120, Platform.PC, 4, Genre.FPS);
        VideoGame forzaHorizon = new VideoGame("Forza Horizon", 2016, 120, Platform.PC, 4, Genre.RACING);
        VideoGame tombRaider = new VideoGame("Tomb Raider", 1998, 120, Platform.PS5, 4, Genre.ACTION);
        TableGame monopoly = new TableGame("Monopoly", 1990, 40, 4, 70);
        TableGame dixit = new TableGame("Dixit", 2012, 30, 4, 120);
        TableGame pictionary = new TableGame("Pictionary", 2005, 65, 4, 60);
        TableGame cranium = new TableGame("Cranium", 1989, 150, 7, 55);
        TableGame whatDoYouMeme = new TableGame("What do you meme?", 2011, 10, 6, 35);

        ArrayList<Game> games = new ArrayList<>();

        games.add(callOfDuty4);
        games.add(halo);
        games.add(crysis);
        games.add(forzaHorizon);
        games.add(tombRaider);
        games.add(monopoly);
        games.add(dixit);
        games.add(pictionary);
        games.add(cranium);
        games.add(whatDoYouMeme);

        System.out.println("Eccoti una lista di giochi che puoi aggiungere alla tua collezione");
        games.forEach(System.out::println);
        try {
            do {
                System.out.println("Inserisci l'id di un gioco che vuoi aggiungere o premi 0 per passare avanti");
                int input = Integer.parseInt(scanner.nextLine());
                if (input == 0) {
                    break;
                }
                Collection.addToCollection(games, input);
                System.out.println("Collezione aggiornata:");
                Collection.printAllGames();
            }
            while (true);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Inserire un intero non una stringa");
        }
        try {
            System.out.println("Inserisci l'id di un gioco per cercarlo nella lista dei giochi");
            int index = Integer.parseInt(scanner.nextLine());
            System.out.println(Collection.getById(index));
        } catch (NoSuchElementException e) {
            System.out.println("Elemento non esistente");
        }

        try {
            System.out.println("Inserisci un prezzo per trovare giochi che costano uguale o meno");
            int maxPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Giochi che costano meno di " + maxPrice + ":");
            Collection.getCheaperThan(maxPrice).forEach(System.out::println);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Inserire un intero non una stringa");
        }

        try {
            System.out.println("Inserisci il numero di giocatori per trovare il o i giochi con quel numero di giocatori");
            int players = Integer.parseInt(scanner.nextLine());
            System.out.println("Giochi da fare in " + players + ":");
            Collection.getByNumberOfPlayers(players).forEach(System.out::println);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Inserire un intero non una stringa");
        }

        try {
            System.out.println("Inserisci l'id di un gioco che vuoi rimuovere");
            int idToRemove = Integer.parseInt(scanner.nextLine());
            Collection.removeFromGamesList(idToRemove);
            System.out.println("Collezione aggiornata:");
            Collection.printAllGames();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Inserire un intero non una stringa");
        }
        Collection.printStats();
        //Collection.modifyGame(); Non ho fatto in tempo
    }
}
