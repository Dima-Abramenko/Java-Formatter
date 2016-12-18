package it.sevenbits.actions.lexer;

/**
 * Created by oem on 18.12.16.
 */
public class ActionLexerSeparator implements IActionLexer {
    /**
     *
     * @param c comment.
     * @return String.
     */
    public final String execute(final Character c) {
        return "sep";
    }
}
