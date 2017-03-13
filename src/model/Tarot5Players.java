package model;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Tarot5Players extends TarotGame {
    private Participant participantCalled;

    public Tarot5Players(ArrayList<Participant> participants) {
        super(5, participants);
    }

    public Participant getParticipantCalled() {
        return participantCalled;
    }
}
