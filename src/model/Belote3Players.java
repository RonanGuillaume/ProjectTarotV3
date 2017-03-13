package model;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class Belote3Players extends Belote {

    public Belote3Players(ArrayList<Participant> participants) {
        super(3, participants);
    }

    @Override
    String getGameName() {
        return "Belote 3 players";
    }
}
