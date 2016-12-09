package it.sevenbits.states.actionstate;

/**
 * Created by oem on 24.11.16.
 */
public interface IState {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    String getAction(final ActionContext action, final char c);

    /**
     *
     * @return String.
     */
    String getStateName();
}
