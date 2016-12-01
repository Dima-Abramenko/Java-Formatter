package it.sevenbits.action;

/**
 * Created by oem on 30.11.16.
 */
public class ActionSemicolon  implements IAction {

    /**
     *
     * @param current comment.
     * @return String.
     */
    public final String execute(final char current) {
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        if (ActionSelection.isMainCode) {
            sb.append('\n');
            for (int i = 0; i < ActionSelection.rightMargin; i++) {
                sb.append("\t");
            }
        }
        return sb.toString();
    }
}
