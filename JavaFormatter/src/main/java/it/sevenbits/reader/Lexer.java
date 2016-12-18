package it.sevenbits.reader;

import it.sevenbits.actions.lexer.IActionLexer;
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
    private static int count = 0;
    /**
     * comment.
     */
    private static final int SIZE = 100;
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

        while (count <= SIZE) {
            count++;
            return true;
        }
        return false;
    }

    /**
     *
     * @return IToken.
     * @throws ReaderException comment.
     */
    public final IToken read() throws ReaderException {

        IStateLexer stateLexer = new DefaultLexerState();
        while (reader.hasMore()) {
            Character c = reader.read();

            LexerContext context = new LexerContext(stateLexer, c);
            IActionLexer action = context.getAction();
            String buff = action.execute(c);
            if (buff == "skip") {
                String s = lexeme.toString();
                System.out.println(s);
                lexeme.delete(0, lexeme.length());
                return new Token(s);
            }
            if (buff == "sep") {
                String s = lexeme.toString();
                System.out.println(s);
                lexeme.delete(0, lexeme.length());
                lexeme.append(c);
                return new Token(s);
            }
                lexeme.append(buff);

            stateLexer = context.nextState(stateLexer, c);
        }

        return new Token("");
    }
}
