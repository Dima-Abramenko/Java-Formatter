package it.sevenbits.reader;

import it.sevenbits.states.lexerstate.DefaultLexerState;
import it.sevenbits.states.lexerstate.IStateLexer;
import it.sevenbits.states.lexerstate.LexerContext;
import it.sevenbits.token.IToken;
import it.sevenbits.token.Token;

/**
 * Created by oem on 09.12.16.
 */
public class Lexer implements IReader<IToken> {
    /**
     * comment.
     */
    private IReader<Character> reader;
    /**
     * comment.
     */
    private StringBuilder lexeme = new StringBuilder();
    /**
     *
     * @param r comment.
     */
    public Lexer(final IReader<Character> r) {
        reader = r;

    }

    /**
     *
     * @return boolean.
     */
    public final boolean hasMore() {
        return true;
    }

    /**
     *
     * @return Itoken.
     */
    public final IToken read() {
        IStateLexer stateLexer = new DefaultLexerState();
        while (reader.hasMore()) {
            Character c = reader.read();
            LexerContext action = new LexerContext(stateLexer, c);
            lexeme.append(action.getResult());
        }
    return new Token(lexeme.toString());
    }
}
