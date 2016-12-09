package it.sevenbits.states.actionstate;

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
    private char current;
    /**
     * @param iState comment.
     * @param c comment.
     */
    public ActionContext(final IState iState, final char c) {
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
    public final IState getNextState(final IState curState, final char curr) {
        String buff = curState.getStateName() + curr;
        for (String s : Initializator.mapTransitions.keySet()) {
            if (s.equals(buff)) {
                return Initializator.mapTransitions.get(s);
            }
        }
        return curState;
    }
    /**
     *
     * @return String.
     */
    public final String getResult() {
        return state.getAction(this, current);
    }
}
