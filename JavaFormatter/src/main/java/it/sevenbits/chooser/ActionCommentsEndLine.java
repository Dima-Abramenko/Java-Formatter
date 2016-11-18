package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
public class ActionCommentsEndLine implements IChooser {
    /**
     * returns method
     */
    public String writeCode(final char current) {
        Selection.isMainCode = true;
        return Character.toString(current);
    }
}
