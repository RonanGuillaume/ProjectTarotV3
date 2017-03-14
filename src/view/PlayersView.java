package view;

import controller.ManagerListener;
import controller.PlayerEvent;
import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private ManagerListener managerListener;

    private PlayerTableModel playerTableModel;

    public PlayersView(ActionListener actionListener, ManagerListener managerListener, List<Player> players) throws HeadlessException {
        super("Players");

        this.managerListener = managerListener;
        createButton.setActionCommand("CreatePlayer");
        createButton.addActionListener(managerListener);

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
        playerTable.setAutoCreateRowSorter(true);
        playerTable.updateUI();

        setVisible(true);

        playerTable.getSelectionModel().addListSelectionListener(e -> {
            if (playerTable.getSelectedRowCount()!=0){
                deleteButton.setEnabled(true);
                modifyButton.setEnabled(false);
            }
            if (playerTable.getSelectedRowCount()== 1){
                modifyButton.setEnabled(true);
            }
            if (playerTable.getSelectedRowCount()== 0){
                deleteButton.setEnabled(false);
                modifyButton.setEnabled(false);
            }
        });


        deleteButton.addActionListener(e -> firePlayerDeleted());

        modifyButton.addActionListener(e -> firePlayerNameChanged());
    }

    @Override
    public void registerListener(ActionListener actionListener) {
        cancelButton.setActionCommand("GoBackMainView");
        cancelButton.addActionListener(actionListener);
    }

    private void firePlayerNameChanged() {
        managerListener.playerWantToBeModified(new PlayerEvent(playerTableModel.getElementAt(playerTable.getSelectedRow()),
                null));
    }

    private void firePlayerDeleted(){
        Object[] options = { "OK", "Cancel" };
        int choice = JOptionPane.showOptionDialog(this,"Are you sure to want" +
                " to delete the player(s) selected ?", "Delete a player", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,null, options, options[0]);

        if (choice == 0){
            int[] selectedRows = playerTable.getSelectedRows();

            for (int index : selectedRows) {
                managerListener.playerDeleted(new PlayerEvent(playerTableModel.getElementAt(index), null));
            }
            playerTableModel.setPlayers((ArrayList<Player>) Player.getAllPlayers());
            playerTable.clearSelection();
            playerTable.updateUI();
        }
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b){
            playerTableModel.setPlayers((ArrayList<Player>) Player.getAllPlayers());
            playerTable.clearSelection();
            playerTable.updateUI();
        }
    }
}
