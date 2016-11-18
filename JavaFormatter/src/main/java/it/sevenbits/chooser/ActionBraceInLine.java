package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
public class ActionBraceInLine implements IChooser {
    /**
     * returns method
     */
    public String writeCode(final char current) {
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        if (Selection.isMainCode && !Selection.isStringLine) {
            Selection.rightMargin++;
            sb.append("\n");
            for (int i = 0; i < Selection.rightMargin; i++) {
                sb.append("\t");
            }
        }
        return sb.toString();
    }
}
