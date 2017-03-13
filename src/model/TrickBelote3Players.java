package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class TrickBelote3Players extends TrickBelote {
    public TrickBelote3Players(ArrayList<Participant> participants, Participant taker, HashMap<Participant, Integer> pointsEarned, Participant announcerBelote, ArrayList<Participant> capots) {
        super(participants, taker, pointsEarned, announcerBelote, capots);
    }
}
