package controller;

import model.Player;

import java.util.EventObject;

/**
 * Created by Ronan
 * on 13/03/2017.
 */
public class PlayerEvent extends EventObject{
    private Player player;
    private String newName;

    public PlayerEvent(Object source, Player player, String newName) {
        super(source);
        this.player = player;
        this.newName = newName;
    }

    public Player getPlayer() {
        return player;
    }

    public String getNewName() {
        return newName;
    }
}
