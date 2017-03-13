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

    public ManagerController(MainController mainController) {
        this.playersView = new PlayersView(mainController, this, Player.getAllPlayers());
    }

    public void disposePlayerView(){
        playersView.setVisible(false);
    }

    @Override
    public void playerCreated(PlayerEvent playerEvent) {
        Player player = (Player)(playerEvent.getSource());
        player.addNewPlayerBDD();
        goBackPlayerView();
    }

    private void goBackPlayerView() {
        createNewPlayerView.dispose();
        playersView.setVisible(true);
    }

    private void showCreatePlayerView() {
        playersView.setVisible(false);
        createNewPlayerView = new CreateNewPlayerView(this);
    }

    @Override
    public void playerDeleted(PlayerEvent playerEvent) {
        Player player = (Player)(playerEvent.getSource());
        player.removePlayerBDD();
    }

    @Override
    public void playerNameModified(PlayerEvent playerEvent) {
        Player player = (Player)(playerEvent.getSource());

        int numberVictories = player.getNumberOfVictories();
        int numberPlayed = player.getNumberPortionsPlayed();

        player.removePlayerBDD();

        Player modifiedPlayer = new Player(playerEvent.getPlayer().getName(), numberVictories, numberPlayed);

        modifiedPlayer.addNewPlayerBDD();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "CreatePlayer":
                showCreatePlayerView();
                break;
            case "GoBackToPlayerView":
                goBackPlayerView();
                break;
            default:
                playersView.showError("Invalid action performed");
        }
    }
}
