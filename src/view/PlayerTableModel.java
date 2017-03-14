package view;

import model.Player;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronan
 * on 10/03/2017.
 */
public class PlayerTableModel extends AbstractTableModel {
    private ArrayList<Player> players;
    private String[] columnName = {"Name","Number of victories", "Number of game played"};

    public PlayerTableModel(List<Player> players) {
        super();
        if (players==null){
            this.players = new ArrayList<>();
        }
        else {
            this.players = (ArrayList<Player>) players;
        }
    }

    @Override
    public int getRowCount() {
        return players.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnName[columnIndex].equalsIgnoreCase("Name")){
            return String.class;
        }
        return int.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnName[columnIndex]){
            case "Name" :
                return players.get(rowIndex).getName();
            case "Number of victories" :
                return players.get(rowIndex).getNumberOfVictories();
            case "Number of game played" :
                return players.get(rowIndex).getNumberPortionsPlayed();
            default:
                return null;
        }
    }

    public Player getElementAt(int index){
        return players.get(index);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        String playerRowToString = player.toString();
        for (Player myPlayerRow : players) {
            if (myPlayerRow.toString().equalsIgnoreCase(playerRowToString)){
                players.remove(myPlayerRow);
                break;
            }
        }
    }

    public void removePlayerRowAt(int index) throws Exception {
        if(index < 0 || index >= players.size()){
            throw new Exception("Invalid index");
        }
        players.remove(index);
    }

    public void removeAllPlayerRows(){
        while (players.size()>0){
            removePlayer(getElementAt(0));
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
