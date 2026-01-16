package andrea.entities;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Collection {
    private static Set<Game> gamesList = new HashSet<>();

    public Collection(ArrayList<Game> list) {
        this.gamesList = gamesList;
    }

    public static void addToCollection(ArrayList<Game> games, int id) {
        Game foundGame = games.stream().filter(game -> game.getId() == id).findAny().orElse(null);
        if (foundGame == null) {
            throw new NoSuchElementException("Nessun elemento trovato con id " + id);
        } else if (containsId((int) foundGame.getId())) {
            System.out.println("Elemento giá aggiunto alla collezione");
        }
        gamesList.add(foundGame);
    }

    public static void printAllGames() {
        gamesList.forEach(game -> System.out.println(game.toString()));
    }

    public static Game getById(int id) {

        Game foundGame = gamesList.stream().filter(game -> game.getId() == id).findAny().orElse(null);
        if (foundGame == null) {
            throw new NoSuchElementException("Nessun elemento trovato con id " + id);
        }
        return foundGame;
    }

    public static List<Game> getCheaperThan(int price) {
        List<Game> foundCheapers = gamesList.stream().filter(game -> game.getPrice() <= price).sorted(Comparator.comparing(Game::getPrice)).toList();
        if (foundCheapers.isEmpty()) {
            throw new NoSuchElementException("Nessun elemento trovato meno costoso di " + price + " euro");
        }
        return foundCheapers;
    }

    public static List<Game> getByNumberOfPlayers(int players) {
        List<Game> foundByNumber = gamesList.stream().filter(game -> game instanceof TableGame).filter(game -> ((TableGame) game).getPlayers() == players).toList();
        if (foundByNumber.isEmpty()) {
            throw new NoSuchElementException("Nessun gioco da tavolo trovato da fare in " + players);
        }
        return foundByNumber;
    }

    public static void removeFromGamesList(int id) {
        Game foundgame = gamesList.stream().filter(game -> game.getId() == id).findAny().orElse(null);
        if (foundgame == null) {
            throw new NoSuchElementException("Nessun elemento trovato");
        } else {
            gamesList.remove(foundgame);
            System.out.println("Elemento con id: " + foundgame.getId() + "=" + foundgame.getTitle() + " rimosso con successo");
        }
    }

    private static boolean containsId(int id) {
        for (Game game : gamesList) {
            if (game.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void printStats() {
        System.out.println("Numero di giochi nella collezione= " + gamesList.size());
        System.out.println("Il gioco con il prezzo piú alto é: " + gamesList.stream().max(Comparator.comparing(Game::getPrice)));
        System.out.println("La media dei prezzi dei tuoi giochi é: " + gamesList.stream().collect(Collectors.averagingDouble(Game::getPrice)));
    }

    public static void modifyGame(Game game) {
        //Non ho fatto in tempo
    }
}
