package controller;

import model.Player;
import view.CreateNewPlayerView;
import view.PlayersView;

import java.awt.event.ActionEvent;

/**
 * Created by Ronan
 * on 13/03/2017.
 */
public class ManagerController implements ManagerListener{
    private PlayersView playersView;
    private CreateNewPlayerView createNewPlayerView;

    public ManagerController() {
        this.playersView = new PlayersView(this, Player.getAllPlayers());
    }

    @Override
    public void playerCreated(PlayerEvent playerEvent) {
        playerEvent.getPlayer().addNewPlayerBDD();
        goBackPlayerView();
    }

    @Override
    public void goBackPlayerView() {
        createNewPlayerView.dispose();
        playersView = new PlayersView(this, Player.getAllPlayers());
    }

    @Override
    public void showCreatePlayerView() {
        playersView.setVisible(false);
        createNewPlayerView = new CreateNewPlayerView(this);
    }

    @Override
    public void playerDeleted(PlayerEvent playerEvent) {
        playerEvent.getPlayer().removePlayerBDD();
    }

    @Override
    public void playerNameModified(PlayerEvent playerEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
