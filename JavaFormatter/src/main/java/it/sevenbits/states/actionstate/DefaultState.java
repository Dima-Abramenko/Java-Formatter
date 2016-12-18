package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.initializator.Initializator;



/**
 * Created by oem on 04.12.16.
 */
public class DefaultState implements IState {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public final IAction getAction(final ActionContext action, final String c) {
        return Initializator.mapActions.getOrDefault(c,
                new ActionDefault());
    }
    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "default";
    }
}

