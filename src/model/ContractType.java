package model;

/**
 * Created by Ronan
 * on 16/01/2017.
 */
public enum ContractType {
    /**
     * None contract type.
     */
    NONE(0), /**
     * Prise contract type.
     */
    PRISE(1), /**
     * Garde contract type.
     */
    GARDE(2), /**
     * Garde sans contract type.
     */
    GARDE_SANS(4), /**
     * Garde contre contract type.
     */
    GARDE_CONTRE(6);

    /**
     * The Value of multiplicator.
     */
    int valueOfMultiplicator;

    ContractType(int valueOfMultiplicator) {
        this.valueOfMultiplicator = valueOfMultiplicator;
    }

    /**
     * Gets value of multiplicator.
     *
     * @return the value of multiplicator
     */
    public int getValueOfMultiplicator() {
        return valueOfMultiplicator;
    }
}
