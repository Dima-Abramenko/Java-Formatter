package it.sevenbits.state;


import it.sevenbits.action.IAction;

import java.util.HashMap;

/**
 * Created by oem on 04.12.16.
 */
public class Action {
    /**
     * comment.
     */
    private IState state;
    /**
     * comment.
     */
    private char current;
    /**
     * comment.
     */
    private HashMap<String, IState> mapTransitions;
    /**
     * @param state comment.
     * @param current comment.
     */
    public Action(final IState state, final char current) {
        this.state = state;
        this.current = current;
        mapTransitions = new HashMap<>();
        mapTransitions.put("DefaultState\"", new StringLiteralState());
        mapTransitions.put("Str\"", new DefaultState());
    }
    /**
     * @param state comment.
     */
    public void setState(final IState state) {
        this.state = state;
    }
    /**
     * @return IState.
     */
    public IState getState() {
        return state;
    }
    /**
     *
     * @param currentState comment.
     * @param current comment.
     * @return String.
     */
    public IState getNextState(final IState currentState, final char current) {
        String buff = currentState.getStateName()+current;
        for(String s : mapTransitions.keySet()) {
            if (s.equals(buff)) {
                return mapTransitions.get(s);
            }
        }
        return currentState;
    }
    /**
     *
     * @return String.
     */
    public String getAction() {
        return state.getAction(this, current);
    }
}
