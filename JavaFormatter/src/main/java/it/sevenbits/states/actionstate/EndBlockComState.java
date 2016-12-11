package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.IAction;

/**
 * Created by oem on 12.12.16.
 */
public class EndBlockComState implements IState {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public final IAction getAction(final ActionContext action, final char c) {
        IAction actionDefault = new ActionDefault();
        return actionDefault;
    }

    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "End";
    }
}
