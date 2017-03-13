package view;

import controller.ManagerController;
import controller.PlayerEvent;
import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 13/03/2017.
 */
public class CreateNewPlayerView extends AbstractView{
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JButton cancelButton;
    private JButton addButton;
    private JLabel errorLabel;
    private ManagerController managerController;

    public CreateNewPlayerView(ManagerController managerController) throws HeadlessException {
        super("Create a new player");

        this.managerController = managerController;

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        registerListener(managerController);

        improvePlacement();

        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.red);
        addButton.setEnabled(false);


        setVisible(true);


        nameTextField.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                errorLabel.setVisible(false);
                if(nameTextField.getText().length()==0){
                    addButton.setEnabled(false);
                }
                else if (Player.nameExistsInTheBDD(nameTextField.getText())){
                    errorLabel.setVisible(true);
                    addButton.setEnabled(false);
                }
                else {
                    addButton.setEnabled(true);
                }
            }
        });


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firePlayerCreated();
            }
        });
    }

    @Override
    public void registerListener(ActionListener actionListener) {
        cancelButton.setActionCommand("GoBackToPlayerView");
        cancelButton.addActionListener(actionListener);
    }



    private void firePlayerCreated(){
        Player newPlayer = new Player(nameTextField.getText());
        managerController.playerCreated(new PlayerEvent(new Player(nameTextField.getText()), null));
    }
}
