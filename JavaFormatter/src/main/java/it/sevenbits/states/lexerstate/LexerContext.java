package it.sevenbits.states.lexerstate;

import it.sevenbits.actions.lexer.IActionLexer;
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
     * @param st comment.
     * @param c comment.
     * @return String.
     */
    public final IStateLexer nextState(final IStateLexer st, final char c) {
        String buff = st.getStateName() + c;
        return Initializator.mapLexerTransition.getOrDefault(buff, st);
    }

    /**
     *
     * @return String.
     */
    public final IActionLexer getAction() {
        return state.getAction(this, current);
    }
}
