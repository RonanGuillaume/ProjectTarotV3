package view;

import controller.ManagerListener;
import controller.PlayerEvent;
import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 14/03/2017.
 */
public class ModifyPlayerView extends AbstractView{
    private JButton cancelButton;
    private JButton validateButton;
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JPanel mainPanel;
    private JLabel errorLabel;
    private Player player;
    private ManagerListener managerListener;

    public ModifyPlayerView(ManagerListener actionListener, Player player) throws HeadlessException {
        super("Update a player");

        this.player = player;
        nameLabel.setText(player.getName());

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        this.managerListener = actionListener;
        registerListener(actionListener);

        improvePlacement();

        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.red);
        validateButton.setEnabled(false);

        setVisible(true);

        nameTextField.addCaretListener(e -> {
            errorLabel.setVisible(false);
            if(nameTextField.getText().length()==0){
                validateButton.setEnabled(false);
            }
            else if (Player.nameExistsInTheBDD(nameTextField.getText())
                    && !nameTextField.getText().equalsIgnoreCase(nameLabel.getText())){
                errorLabel.setVisible(true);
                validateButton.setEnabled(false);
            }
            else {
                validateButton.setEnabled(true);
            }
        });


        validateButton.addActionListener(e -> firePlayerModified());
    }

    private void firePlayerModified() {
        managerListener.playerNameModified(new PlayerEvent(player, new Player(nameTextField.getText())));
    }

    @Override
    public void registerListener(ActionListener actionListener) {
        cancelButton.setActionCommand("GoBackPlayerView");
        cancelButton.addActionListener(actionListener);
    }
}
