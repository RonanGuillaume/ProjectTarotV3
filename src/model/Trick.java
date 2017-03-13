package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public abstract class Trick {
    protected HashMap<Participant,Integer> scores;
    private ArrayList<Participant> trickParticipants;
    private CardGame myCardGame;

    public Trick() {
    }

    public Trick(ArrayList<Participant> trickParticipants) {
        this.scores = new HashMap<>();
        this.trickParticipants = trickParticipants;
    }

    public ArrayList<Participant> getTrickParticipants() {
        return trickParticipants;
    }

    public HashMap<Participant, Integer> getScores() {
        return scores;
    }

    public CardGame getMyCardGame() {
        return myCardGame;
    }

    public abstract void calculateScore();
}
