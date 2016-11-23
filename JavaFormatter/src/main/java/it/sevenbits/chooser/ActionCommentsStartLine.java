package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
class ActionCommentsStartLine implements IChooser {
    /**
     * returns method.
     * @return String
     * @param current This is current symbol
     */
    public final String writeCode(final char current) {
        Selection.isMainCode = false;
        return Character.toString(current);
    }

}
