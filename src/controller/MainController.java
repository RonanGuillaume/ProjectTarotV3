package controller;

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
            default:
                mainView.showError("Invalid action performed");
        }
    }

    private void showMainView() {
        playersView.dispose();
        mainView.setVisible(true);
    }

    private void managePlayers() {
        mainView.setVisible(false);
        playersView = new PlayersView(this, null);
    }

    private void starGame() {

    }
}
