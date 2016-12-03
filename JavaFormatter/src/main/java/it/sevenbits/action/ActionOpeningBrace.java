package it.sevenbits.action;

/**
 * Created by oem on 30.11.16.
 */
public class ActionOpeningBrace implements IAction {
    /**
     *
     * @param current comment.
     * @return String.
     */
    public final String execute(final char current) {
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        if (Selection.isMainCode && !Selection.isComment) {
            sb.append("\n");
            Selection.rightMargin++;
            for (int i = 0; i < Selection.rightMargin; i++) {
                sb.append("\t");
            }
        }

        return sb.toString();
    }
}
