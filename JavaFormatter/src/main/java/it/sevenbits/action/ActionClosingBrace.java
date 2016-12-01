package it.sevenbits.action;

/**
 * Created by oem on 30.11.16.
 */
public class ActionClosingBrace implements IAction {
    /**
     *
     * @param current comment.
     * @return String.
     */
    public final String execute(final char current) {
        return Character.toString(current);
    }
}
