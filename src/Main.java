import controller.MainController;
import model.*;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 16/02/2017.
 */
public class Main {
    public static void main(String[] args){
        MainController mainController = new MainController();
//        fillPlayers();
//        fillCardGames();
    }

    private static void fillPlayers(){
        Player player = new Player("Ronan");
        Player player2 = new Player("Marianne");
        player.participateGame();
        player.winGame();
        player.addNewPlayerBDD();
        player2.addNewPlayerBDD();
    }

    private static void fillCardGames(){
        Player player = new Player("Ronan");
        Player player1 = new Player("Ronan1");
        Player player2 = new Player("Ronan2");
        Player player3 = new Player("Ronan3");
        Player player4 = new Player("Ronan4");

        ArrayList<Participant> players = new ArrayList<>();
        players.add(player);
        players.add(player1);
        players.add(player2);

        Belote belote = new Belote(0, new ArrayList<>());
        Belote3Players belote3Players = new Belote3Players(players);

        players.add(player3);
        players.add(player4);

        TarotGame tarotGame = new TarotGame(0, new ArrayList<>());
        Tarot5Players tarot5Players = new Tarot5Players(players);

        belote.addGameToBDD();
        belote3Players.addGameToBDD();
        tarot5Players.addGameToBDD();
        tarotGame.addGameToBDD();
    }
}
