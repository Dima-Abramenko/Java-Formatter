package it.sevenbits.actions.formatter;

/**
 * Created by oem on 24.11.16.
 */
public class ActionDefault implements IAction {
    /**
     *
     * @param current comment.
     * @return String.
     */
    public final String execute(final char current) {
        return Character.toString(current);
    }
}
