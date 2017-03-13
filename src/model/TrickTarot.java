package model;

import java.util.ArrayList;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public class TrickTarot extends Trick{
    private Participant taker;
    private int trickValue;
    private TrickTarotDescription description;

    public TrickTarot(ArrayList<Participant> trickParticipant, Participant taker, int trickValue, TrickTarotDescription description) {
        super(trickParticipant);
        this.taker = taker;
        this.trickValue = trickValue;
        this.description = description;
        calculateTrickValue();
    }

    public TrickTarotDescription getDescription() {
        return description;
    }

    public Participant getTaker() {
        return taker;
    }

    public int getTrickValue() {
        return trickValue;
    }

    @Override
    public void calculateScore() {
        for (Participant participant : getTrickParticipants()) {
            scores.put(participant, trickValue*-1);
        }
        scores.put(taker, trickValue*getTrickParticipants().size() - 1);
    }

    private void calculateTrickValue(){
        int margin = description.getPointsMarkedAttacker() - description.getNumberBoutsTaker().getContractValue();

        if (margin < 0){
            description.setWin(false);
            margin *= -1;
        }
        else {
            description.setWin(true);
        }

        trickValue = ((25 + margin + description.getPetitAuBoutBonus().getValueOfBonus())
                * description.getContract().getValueOfMultiplicator()) + description.getPoigneeBonus().getValueOfBonus();

        if (!description.isWin()){
            trickValue *= -1;
        }

        if (description.getChelemBonus() != ChelemBonus.NONE){
            if (description.getChelemAnnouncer().isEqual(taker)){
                trickValue += description.getChelemBonus().getValueOfBonus();
            }
            else {
                trickValue -= description.getChelemBonus().getValueOfBonus();
            }
        }
    }
}
