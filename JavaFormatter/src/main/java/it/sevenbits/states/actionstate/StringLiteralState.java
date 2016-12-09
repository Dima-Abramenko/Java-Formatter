package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.IAction;

/**
 * Created by oem on 04.12.16.
 */
public class StringLiteralState implements IState {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public final String getAction(final ActionContext action, final char c) {
        IAction actionDefault = new ActionDefault();
        return actionDefault.execute(c);
    }

    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "Str";
    }
}
