package it.sevenbits.states.lexerstate;

import it.sevenbits.actions.lexer.IActionLexer;

/**
 * Created by oem on 09.12.16.
 */
public interface IStateLexer {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    IActionLexer getAction(final LexerContext action, final char c);

    /**
     *
     * @return String.
     */
    String getStateName();
}
