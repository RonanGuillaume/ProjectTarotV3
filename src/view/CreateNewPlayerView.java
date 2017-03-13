package view;

import controller.ManagerListener;
import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

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

    public CreateNewPlayerView(ManagerListener actionListener) throws HeadlessException {
        super("Create a new player");

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        if(actionListener != null){
            registerListener(actionListener);
        }

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
    }

    @Override
    public void registerListener(EventListener actionListener) {
        cancelButton.setActionCommand("GoBackToPlayerView");
        cancelButton.addActionListener(actionListener);
        addButton.setActionCommand("AddNewPlayer");
        addButton.addActionListener(actionListener);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }
}
