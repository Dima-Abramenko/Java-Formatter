package it.sevenbits.actions.formatter;

import it.sevenbits.initializator.Initializator;

/**
 * Created by oem on 05.12.16.
 */
public class ActionSemicolon implements IAction {
    /**
     *
     * @param current comment.
     * @return String.
     */
    public final String execute(final char current) {
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        sb.append("\n");
        for (int i = 0; i < Initializator.rightMargin; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
