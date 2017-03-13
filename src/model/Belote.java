package model;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Belote extends CardGame {

    public Belote(int numberParticipants, ArrayList<Participant> participants) {
        super(numberParticipants, participants);
    }

    @Override
    String getGameName() {
        return "Belote";
    }

    @Override
    protected void calculateRanking() {

    }
}
