package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
public class ActionStringLineEnd implements IChooser {
    /**
     * returns method
     */
    public String writeCode(final char current) {
        Selection.isStringLine = false;
        return Character.toString(current);
    }
}
