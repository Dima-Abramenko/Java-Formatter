package it.sevenbits.states.lexerstate;

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
    String getAction(final LexerContext action, final char c);

    /**
     *
     * @return String.
     */
    String getStateName();
}
