package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
class ActionMarginTrue implements IChooser {
    /**
     * returns method.
     * @return String
     * @param current This is current symbol
     */
    public final String writeCode(final char current) {
        Selection.isMainCode = true;
        return Character.toString(current);
    }
}
