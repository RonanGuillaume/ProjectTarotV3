package view;

import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Ronan
 * on 10/03/2017.
 */
public class PlayersView extends AbstractView{
    private JPanel mainPanel;
    private JTable playerTable;
    private JButton modifyButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JButton createButton;

    private PlayerTableModel playerTableModel;

    public PlayersView(ActionListener actionListener, List<Player> players) throws HeadlessException {
        super("Players");

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        if(actionListener != null){
            registerListener(actionListener);
        }

        improvePlacement();

        playerTableModel = new PlayerTableModel(players);
        playerTable.setModel(playerTableModel);
        playerTable.updateUI();

        setVisible(true);
    }

    @Override
    public void registerListener(ActionListener actionListener) {
        cancelButton.setActionCommand("GoBackMainView");
        cancelButton.addActionListener(actionListener);
    }
}
