package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class TrickBelote extends Trick {
    private Participant taker;
    private HashMap<Participant, Integer> pointsEarned;
    private Participant announcerBelote;
    private ArrayList<Participant> capots;

    public TrickBelote(ArrayList<Participant> participants, Participant taker, HashMap<Participant, Integer> pointsEarned, Participant announcerBelote, ArrayList<Participant> capots) {
        super(participants);
        this.taker = taker;
        this.pointsEarned = pointsEarned;
        this.announcerBelote = announcerBelote;
        this.capots = capots;
    }

    public HashMap<Participant, Integer> getPointsEarned() {
        return pointsEarned;
    }

    public ArrayList<Participant> getCapots() {
        return capots;
    }

    public Participant getTaker() {
        return taker;
    }

    public Participant getAnnouncerBelote() {
        return announcerBelote;
    }

    @Override
    public void calculateScore() {

    }
}
