package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.IAction;

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
    IAction getAction(final ActionContext action, final String c);

    /**
     *
     * @return String.
     */
    String getStateName();
}
