package it.sevenbits.state;

import it.sevenbits.action.ActionDefault;
import it.sevenbits.action.IAction;

/**
 * Created by oem on 04.12.16.
 */
public class StringLiteralState implements IState{
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public String getAction(Action action, char c) {
        IAction actionDefault = new ActionDefault();
        return actionDefault.execute(c);
    }
    public String getStateName() {
        return "Str";
    }
}
