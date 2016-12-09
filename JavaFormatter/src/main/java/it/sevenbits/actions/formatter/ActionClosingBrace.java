package it.sevenbits.actions.formatter;

import it.sevenbits.initializator.Initializator;

/**
 * Created by oem on 05.12.16.
 */
public class ActionClosingBrace implements IAction {
    /**
     *
     * @param current comment.
     * @return String.
     */
    public final String execute(final char current) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        Initializator.rightMargin--;
        for (int i = 0; i < Initializator.rightMargin; i++) {
            sb.append("\t");
        }
        sb.append(current);
        sb.append("\n");
        return sb.toString();
    }
}
