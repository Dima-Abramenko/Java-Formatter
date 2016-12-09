package it.sevenbits.actions.formatter;


/**
 * Created by oem on 24.11.16.
 */
public interface IAction {
    /**
     * @return String
     * @param current comment.
     */
    String execute(final char current);
}
