package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
public class ActionSemicolonNewLine implements IChooser {
    /**
     * entry method
     */
    public String writeCode(final char current) {
        return Character.toString(current);
    }
}
