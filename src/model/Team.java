package model;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Team implements Participant{
    private String teamName;
    private ArrayList<Player> players;

    public Team(String teamName, ArrayList<Player> players) {
        for (int i = 0; i < players.size() - 1; i++){
            for (int j = i + 1; j < players.size(); j++){
                if (players.get(i) == players.get(j)){
                    throw new IllegalArgumentException("There is the same player twice in the team");
                }
            }
        }
        this.teamName = teamName;
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public String getName() {
        return teamName;
    }

    @Override
    public void winGame() {
        for (Player player : players) {
            player.winGame();
        }
    }

    @Override
    public void participateGame() {
        for (Player player : players) {
            player.participateGame();
        }
    }

    @Override
    public boolean isEqual(Participant participant) {
        boolean result = false;
        for (Player myPlayer : players) {
            if (myPlayer.isEqual(participant)){
                result = true;
                break;
            }
        }
        return result;
    }
}
