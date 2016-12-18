package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.IAction;

/**
 * Created by oem on 18.12.16.
 */
public class ForState implements IState {
    /**
    *
    * @param action comment.
    * @param c comment.
    * @return String.
    */
    public final IAction getAction(final ActionContext action, final String c) {
    return new ActionDefault();
}

    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "for";
    }
}
