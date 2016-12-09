package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.initializator.Initializator;

import java.util.HashMap;


/**
 * Created by oem on 04.12.16.
 */
public class DefaultState implements IState {
    /**
     * comment.
     */
    private HashMap<String, IAction> chooser;

    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public final String getAction(final ActionContext action, final char c) {

        for (String s : Initializator.mapActions.keySet()) {
            if (s.equals(Character.toString(c))) {
                return Initializator.mapActions.get(s).execute(c);
            }
        }
        return new ActionDefault().execute(c);
    }
    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "DefaultState";
    }
}

