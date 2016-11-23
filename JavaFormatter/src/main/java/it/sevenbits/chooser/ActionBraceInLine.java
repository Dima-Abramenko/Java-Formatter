package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */mvn
class ActionBraceInLine implements IChooser {
    /**
     * returns method.
     * @return String
     * @param current This is current symbol
     */
    public final String writeCode(final char current) {
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
