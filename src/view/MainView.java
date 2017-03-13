package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Ronan
 * on 10/03/2017.
 */
public class MainView extends AbstractView{
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton startAGameButton;
    private JButton managePlayersButton;

    public MainView(ActionListener actionListener) throws HeadlessException {
        super("House of cards");

        //Set margin
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        mainPanel.setBorder(padding);
        setContentPane(mainPanel);

        if(actionListener != null){
            registerListener(actionListener);
        }

        improvePlacement();

        //Action when we click on exit
        exitButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        setVisible(true);
    }

    @Override
    public void registerListener(ActionListener actionListener) {
        startAGameButton.setActionCommand("StartGame");
        startAGameButton.addActionListener(actionListener);
        managePlayersButton.setActionCommand("ManagePlayers");
        managePlayersButton.addActionListener(actionListener);
    }
}
