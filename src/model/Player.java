package model;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Player implements Participant{
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
