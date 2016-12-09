package it.sevenbits.actions.formatter;

import it.sevenbits.initializator.Initializator;

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
        sb.append("\n");
        Initializator.rightMargin++;
        for (int i = 0; i < Initializator.rightMargin; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }


}
