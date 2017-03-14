package view;

import model.CardGame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 14/03/2017.
 */
public class ChoiceGameView extends AbstractView{

    private JPanel mainPanel;
    private JButton cancelButton;
    private JButton validateButton;
    private JComboBox<CardGame> choiceComboBox;
    private CardGameComboBoxModel cardGameComboBoxModel;

    public ChoiceGameView(ActionListener actionListener) throws HeadlessException {
        super("Choice card game");

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        if(actionListener != null){
            registerListener(actionListener);
        }

        cardGameComboBoxModel = new CardGameComboBoxModel();
        choiceComboBox.setModel(cardGameComboBoxModel);
        choiceComboBox.updateUI();

        improvePlacement();

        setVisible(true);
    }

    @Override
    public void registerListener(ActionListener actionListener) {
        validateButton.setActionCommand("ValidateGameChoice");
        cancelButton.setActionCommand("GoBackMainView");
        validateButton.addActionListener(actionListener);
        cancelButton.addActionListener(actionListener);
    }
}
