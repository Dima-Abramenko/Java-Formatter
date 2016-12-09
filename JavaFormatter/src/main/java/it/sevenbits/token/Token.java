package it.sevenbits.token;

/**
 * Created by oem on 09.12.16.
 */
public class Token implements IToken {
    /**
     * comment.
     */
    private String lexeme;

    /**
     *
     * @param s comment.
     */
    public Token(final String s) {
        lexeme = s;
    }
    /**
     *
     * @return String.
     */
    public final String getLexeme() {
        return lexeme;
    }
}
