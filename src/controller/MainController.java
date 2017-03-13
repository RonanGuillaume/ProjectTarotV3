package controller;

import model.Player;
import view.CreateNewPlayerView;
import view.MainView;
import view.PlayersView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 10/03/2017.
 */
public class MainController implements ActionListener{
    private MainView mainView;
    private PlayersView playersView;
    private CreateNewPlayerView createNewPlayerView;

    public MainController() {
        mainView = new MainView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "StartGame":
                starGame();
                break;
            case "ManagePlayers":
                managePlayers();
                break;
            case "GoBackMainView":
                showMainView();
                break;
            case "CreatePlayer":
                showCreatePlayerView();
                break;
            case "GoBackToPlayerView":
                goBackPlayerView();
                break;
            default:
                mainView.showError("Invalid action performed");
        }
    }

    private void goBackPlayerView() {
        createNewPlayerView.dispose();
        playersView = new PlayersView(this, Player.getAllPlayers());
    }

    private void showCreatePlayerView() {
        playersView.setVisible(false);
        createNewPlayerView = new CreateNewPlayerView(this);
    }

    private void showMainView() {
        playersView.dispose();
        mainView.setVisible(true);
    }

    private void managePlayers() {
        mainView.setVisible(false);
        playersView = new PlayersView(this, Player.getAllPlayers());
    }

    private void starGame() {

    }
}
