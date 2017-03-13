package model;

/**
 * Created by Ronan
 * on 16/01/2017.
 */
public enum ChelemBonus {
    /**
     * None chelem bonus.
     */
    NONE(0),

    /**
     * Annonce realise chelem bonus.
     */
    ANNOUNCED_REALISED(400),

    /**
     * Not annonce realise chelem bonus.
     */
    NOT_ANNOUNCED_REALISED(200),

    /**
     * Annonce not realise chelem bonus.
     */
    ANNOUNCED_NOT_REALISE(-200);

    /**
     * The Value of bonus.
     */
    int valueOfBonus;

    ChelemBonus(int valueOfBonus) {
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
