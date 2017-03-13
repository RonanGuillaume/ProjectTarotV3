package controller;

import model.Player;

import java.util.EventObject;

/**
 * Created by Ronan
 * on 13/03/2017.
 */
public class PlayerEvent extends EventObject{
    private Player player;

    public PlayerEvent(Object source, Player player) {
        super(source);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
