package model;

import controller.FileManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Player implements Participant, Serializable{
    private String name;
    private int numberOfVictories;
    private int numberPortionsPlayed;

    public Player(String name) {
        this.name = name;
        this.numberOfVictories = 0;
        this.numberPortionsPlayed = 0;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public int getNumberPortionsPlayed() {
        return numberPortionsPlayed;
    }

    static public List<Player> getAllPlayers(){
        return (ArrayList<Player>) FileManager.readFromFile("config/players.bar");
    }

    public void savePlayer(){
        ArrayList<Player> players = (ArrayList<Player>) getAllPlayers();
        if(players==null){
            players = new ArrayList<>();
        }
        players.remove(this);
        players.add(this);
        FileManager.writeToFile("config/players.bar", players);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void winGame() {
        numberOfVictories++;
    }

    @Override
    public void participateGame() {
        numberPortionsPlayed++;
    }

    @Override
    public boolean isEqual(Participant participant) {
        return (this == participant);
    }
}
