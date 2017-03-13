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
    private ManagerController managerController;
    private GameController gameManager;
    private MainView mainView;
    private PlayersView playersView;
    private CreateNewPlayerView createNewPlayerView;

    public MainController() {
        managerController = new ManagerController();
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
            case "AddNewPlayer":
                addNewPlayer();
                break;
            default:
                mainView.showError("Invalid action performed");
        }
    }

    private void showMainView() {
        playersView.dispose();
        mainView.setVisible(true);
    }

    private void starGame() {

    }
}
