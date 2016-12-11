package it.sevenbits.states.lexerstate;

import it.sevenbits.actions.lexer.ActionLexerDefault;
import it.sevenbits.actions.lexer.IActionLexer;
import it.sevenbits.initializator.Initializator;

/**
 * Created by oem on 09.12.16.
 */
public class DefaultLexerState implements IStateLexer {
    /**
     *
     * @param act comment.
     * @param c comment.
     * @return String.
     */
    public final IActionLexer getAction(final LexerContext act, final char c) {
        return Initializator.mapLexerActions.getOrDefault(Character.toString(c),
                new ActionLexerDefault());
    }

    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "default";
    }
}
