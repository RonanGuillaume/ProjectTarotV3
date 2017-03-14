package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class TarotGame extends CardGame implements Serializable{

    public TarotGame(int numberParticipants, ArrayList<Participant> participants) {
        super(numberParticipants, participants);
    }

    @Override
    String getGameName() {
        return "Tarot";
    }

    @Override
    protected void calculateRanking() {
        ArrayList<Participant> myParticipants = getParticipants();
        HashMap<Participant, Integer> myTotals = getTotals();
        int maxValue = -1;
        Participant itemToMove;

        for(int i = 0; i < myParticipants.size() - 1; i++){
            itemToMove = myParticipants.get(i);
            for (int j = i; j < myParticipants.size(); j++) {
                if (myTotals.get(myParticipants.get(j)) > maxValue){
                    maxValue = myTotals.get(myParticipants.get(j));
                    itemToMove = myParticipants.get(j);
                }
            }
            Collections.swap(myParticipants, myParticipants.indexOf(itemToMove), i);
        }
    }
}
