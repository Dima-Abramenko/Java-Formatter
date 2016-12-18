package it.sevenbits.states.actionstate;

import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.initializator.Initializator;

/**
 * Created by oem on 04.12.16.
 */
public class ActionContext {
    /**
     * comment.
     */
    private IState state;
    /**
     * comment.
     */
    private String current;
    /**
     * @param iState comment.
     * @param c comment.
     */
    public ActionContext(final IState iState, final String c) {
        state = iState;
        current = c;
    }
    /**
     * @param iState comment.
     */
    public final void setState(final IState iState) {
        state = iState;
    }
    /**
     * @return IState.
     */
    public final IState getState() {
        return state;
    }
    /**
     *
     * @param curState comment.
     * @param curr comment.
     * @return String.
     */
    public final IState getNextState(final IState curState, final String curr) {
        String buff = curState.getStateName() + curr;
        return Initializator.mapTransitions.getOrDefault(buff, curState);
    }
    /**
     *
     * @return String.
     */
    public final IAction getAction() {
        return state.getAction(this, current);
    }
}
