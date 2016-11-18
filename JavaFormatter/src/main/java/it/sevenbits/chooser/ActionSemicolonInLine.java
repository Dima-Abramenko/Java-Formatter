package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
public class ActionSemicolonInLine implements IChooser {
    /**
     * entry method
     */
    public String writeCode(final char current) {
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        if (Selection.isMainCode  && !Selection.isStringLine) {
            sb.append('\n');
            for (int i = 0; i < Selection.rightMargin +1; i++) {
                sb.append("\t");
            }
        }
        return sb.toString();
    }
}
