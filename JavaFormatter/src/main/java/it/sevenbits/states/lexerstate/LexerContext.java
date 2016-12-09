package it.sevenbits.states.lexerstate;

import it.sevenbits.initializator.Initializator;


/**
 * Created by oem on 09.12.16.
 */
public class LexerContext {
    /**
     * comment.
     */
    private IStateLexer state;
    /**
     * comment.
     */
    private Character current;
    /**
     *
     * @param iState comment.
     * @param c comment.
     */
    public LexerContext(final IStateLexer iState, final char c) {
        state = iState;
        current = c;
    }

    /**
     *
     * @param state comment.
     * @param c comment.
     * @return String.
     */
    public final IStateLexer NextState(final IStateLexer state, final char c) {
        String buff = state.getStateName() + c;
        for (String s : Initializator.mapLexerTransition.keySet()) {
            if (s.equals(buff)) {
                return Initializator.mapLexerTransition.get(s);
            }
        }
        return state;
    }

    /**
     *
     * @return String.
     */
    public final String getResult() {
        return state.getAction(this, current);
    }
}
