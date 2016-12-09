package it.sevenbits.states.lexerstate;

/**
 * Created by oem on 09.12.16.
 */
public class InLineCommentLexerState implements IStateLexer {
    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public final String getAction(final LexerContext action, final char c) {
        return "";
    }

    /**
     *
     * @return String.
     */
    public  final String getStateName() {
        return "inline";
    }
}
