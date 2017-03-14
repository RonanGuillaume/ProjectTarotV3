package model;

import controller.FileManager;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public abstract class CardGame implements Serializable{
    private boolean isEnded;
    private Participant winner;
    private Calendar startDate;
    private int numberParticipants;
    private ArrayList<Trick> tricks;
    private ArrayList<Participant> participants;
    private HashMap<Participant,Integer> totals;


    public CardGame(int numberParticipants, ArrayList<Participant> participants) {
        if (participants.size() != numberParticipants){
            throw new IllegalArgumentException("Not the right number of participants.");
        }

        for (int i = 0; i < participants.size() - 1; i++){
            for (int j = i + 1; j < participants.size(); j++){
                if (participants.get(i).isEqual(participants.get(j))){
                    throw new IllegalArgumentException("There is the same participant twice in the game");
                }
            }
        }

        this.isEnded = false;
        this.winner = null;
        this.startDate = Calendar.getInstance();
        this.numberParticipants = numberParticipants;
        this.tricks = new ArrayList<>();
        this.participants = participants;
        this.totals = new HashMap<>();

        for (Participant participant :this.participants){
            this.totals.put(participant, 0);
        }
    }

    public boolean isEnded() {
        return isEnded;
    }

    public Participant getWinner() {
        return winner;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public int getNumberParticipants() {
        return numberParticipants;
    }

    public Collection<Trick> getTricks() {
        return tricks;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public HashMap<Participant, Integer> getTotals() {
        return totals;
    }

    public void finishGame(){
        isEnded = true;

        this.winner = participants.get(0);
        this.winner.winGame();
    }

    public void finishGame(Participant winner){
        isEnded = true;
        this.winner = winner;
        this.winner.winGame();
    }

    protected void addTrick(Trick trick) {
        trick.calculateScore();
        tricks.add(trick);
        for (Participant participant : participants) {
            totals.put(participant, totals.get(participant) + trick.getScores().get(participant));
        }
        calculateRanking();
    }

    static public ArrayList<CardGame> getAllCardGames(){
        return (ArrayList<CardGame>) FileManager.readFromFile("config/games.bar");
    }

    public void addGameToBDD(){
        ArrayList<CardGame> cardGames = (ArrayList<CardGame>) getAllCardGames();
        if(cardGames==null){
            cardGames = new ArrayList<>();
        }
        cardGames.add(this);
        FileManager.writeToFile("config/games.bar", cardGames);
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    public void setWinner(Participant winner) {
        this.winner = winner;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setNumberParticipants(int numberParticipants) {
        this.numberParticipants = numberParticipants;
    }

    public void setTricks(ArrayList<Trick> tricks) {
        this.tricks = tricks;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public void setTotals(HashMap<Participant, Integer> totals) {
        this.totals = totals;
    }

    @Override
    public String toString() {
        return getGameName();
    }

    abstract String getGameName();
    abstract protected void calculateRanking();
}
