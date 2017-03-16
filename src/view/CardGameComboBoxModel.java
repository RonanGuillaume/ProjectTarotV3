package view;

import model.CardGame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Ronan
 * on 14/03/2017.
 */
public class CardGameComboBoxModel extends AbstractListModel<CardGame> implements ComboBoxModel<CardGame>{
    private ArrayList<CardGame> cardGames;
    private CardGame selectedItem;

    public CardGameComboBoxModel() {
        cardGames = CardGame.getAllCardGames();
        selectedItem = cardGames.get(0);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem == null){
            selectedItem = null;
        }
        else {
            selectedItem = (CardGame) anItem;
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return cardGames.size();
    }

    @Override
    public CardGame getElementAt(int index) {
        return cardGames.get(index);
    }

    public void addCardGame(CardGame cardGame){
        cardGames.add(cardGame);
    }
}
