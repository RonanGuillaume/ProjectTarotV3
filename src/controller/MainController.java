package controller;

import view.ChoiceGameView;
import view.MainView;

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
    private ChoiceGameView choiceGameView;

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
                managePlayer();
                break;
            case "GoBackMainView":
                showMainView();
                break;
            default:
                mainView.showError("Invalid action performed");
        }
    }

    private void managePlayer() {
        managerController = new ManagerController(this);
        mainView.setVisible(false);
    }

    private void showMainView() {
        if (managerController != null){
            managerController.disposePlayerView();
        }
        if (choiceGameView != null){
            choiceGameView.setVisible(false);
        }
        mainView.setVisible(true);
    }

    private void starGame() {
        choiceGameView = new ChoiceGameView(this);
        mainView.setVisible(false);
    }
}
