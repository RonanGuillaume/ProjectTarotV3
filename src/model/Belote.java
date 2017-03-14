package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Belote extends CardGame implements Serializable {

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
