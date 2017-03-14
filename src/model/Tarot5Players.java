package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Tarot5Players extends TarotGame implements Serializable{
    private Participant participantCalled;

    public Tarot5Players(ArrayList<Participant> participants) {
        super(5, participants);
    }

    public Participant getParticipantCalled() {
        return participantCalled;
    }

    @Override
    String getGameName() {
        return "Tarot 5 players";
    }
}
