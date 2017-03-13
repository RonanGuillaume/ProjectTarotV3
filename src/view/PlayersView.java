package view;

import controller.ManagerListener;
import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.EventListener;
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

    public PlayersView(ManagerListener actionListener, List<Player> players) throws HeadlessException {
        super("Players");

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        if(actionListener != null){
            registerListener(actionListener);
        }

        modifyButton.setEnabled(false);
        deleteButton.setEnabled(false);

        improvePlacement();

        playerTableModel = new PlayerTableModel(players);
        playerTable.setModel(playerTableModel);
        playerTable.updateUI();

        setVisible(true);
    }

    @Override
    public void registerListener(EventListener actionListener) {
        cancelButton.setActionCommand("GoBackMainView");
        cancelButton.addActionListener(actionListener);
        createButton.setActionCommand("CreatePlayer");
        createButton.addActionListener(actionListener);
    }
}
