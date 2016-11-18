package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
public class ActionMarginFalse implements IChooser {
    /**
     * returns method
     */
    public String writeCode(final char current) {
        Selection.isMainCode = true;
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(current);
        return sb.toString();
    }
}
