package model;

/**
 * Created by Ronan
 * on 16/01/2017.
 */
public enum PoigneeBonus {
    /**
     * None poignee bonus.
     */
    NONE(0), /**
     * Simple poignee bonus.
     */
    SIMPLE(20), /**
     * Double poignee bonus.
     */
    DOUBLE(30), /**
     * Triple poignee bonus.
     */
    TRIPLE(40);
    /**
     * The Value of bonus.
     */
    int valueOfBonus;

    PoigneeBonus(int valueOfBonus) {
        this.valueOfBonus = valueOfBonus;
    }

    /**
     * Gets value of bonus.
     *
     * @return the value of bonus
     */
    public int getValueOfBonus() {
        return valueOfBonus;
    }
}
