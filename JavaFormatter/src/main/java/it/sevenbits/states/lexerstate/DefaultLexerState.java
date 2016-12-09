package it.sevenbits.states.lexerstate;

import it.sevenbits.actions.lexer.ActionLexerDefault;
import it.sevenbits.initializator.Initializator;

/**
 * Created by oem on 09.12.16.
 */
public class DefaultLexerState implements IStateLexer {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public final String getAction(final LexerContext action, final char c) {
        for (String s : Initializator.mapLexerActions.keySet()) {
            if (s.equals(Character.toString(c))) {
                return Initializator.mapLexerActions.get(s).execute(c);
            }
        }
        return new ActionLexerDefault().execute(c);
    }

    /**
     *
     * @return String.
     */
    public final String getStateName() {
        return "default";
    }
}
