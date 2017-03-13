package model;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class TrickTarot5Players extends TrickTarot {
    private Participant participantCalled;

    public TrickTarot5Players(ArrayList<Participant> trickParticipant, Participant taker, int trickValue, TrickTarotDescription description, Participant participantCalled) {
        super(trickParticipant, taker, trickValue, description);
        this.participantCalled = participantCalled;
    }

    public Participant getParticipantCalled() {
        return participantCalled;
    }
}
