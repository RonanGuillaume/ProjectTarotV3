package model;

/**
 * Created by Ronan
 * on 13/02/2017.
 */
public interface Participant{

    abstract public String getName();
    abstract public void winGame();
    abstract public void participateGame();
    abstract public boolean isEqual(Participant participant);
}
