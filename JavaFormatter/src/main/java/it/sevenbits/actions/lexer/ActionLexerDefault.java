package it.sevenbits.actions.lexer;

/**
 * Created by oem on 09.12.16.
 */
public class ActionLexerDefault implements IActionLexer {
    /**
     *
     * @param c comment.
     * @return String.
     */
    public final String execute(final Character c) {
        return (Character.toString(c));
    }
}
