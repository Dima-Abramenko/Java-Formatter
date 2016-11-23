package it.sevenbits.chooser;

/**
 * Created by oem on 15.11.16.
 */
class ActionSimpleSymbol implements IChooser {
    /**
     * returns method.
     * @return String
     * @param current This is current symbol
     */
    public final String writeCode(final char current) {

        return Character.toString(current);

    }
}
