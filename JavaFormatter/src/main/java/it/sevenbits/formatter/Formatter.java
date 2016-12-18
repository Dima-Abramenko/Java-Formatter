package it.sevenbits.formatter;

import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.initializator.Initializator;
import it.sevenbits.reader.IReader;
import it.sevenbits.reader.ReaderException;
import it.sevenbits.states.actionstate.ActionContext;
import it.sevenbits.states.actionstate.DefaultState;
import it.sevenbits.states.actionstate.IState;
import it.sevenbits.token.IToken;
import it.sevenbits.writer.IWriter;


/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter<IReader<IToken>, IWriter> {
    /**
     * needs to buffer last char.
     */
    private StringBuilder bufferChar = new StringBuilder();
    /**
     * comment.
     */
    private Initializator init = new Initializator();

    /**
     *
     * @param reader comment.
     * @param writer comment.
     * @throws ReaderException comment.
     */
    public final void format(final IReader<IToken> reader, final IWriter writer)
            throws ReaderException {
        IState currentState = new DefaultState();
        while (reader.hasMore()) {
            IToken token = reader.read();
            String lexeme = token.getLexeme();
            ActionContext context = new ActionContext(currentState, lexeme);
            IAction action = context.getAction();
            String subTotal = action.execute(lexeme);
            for (int i = 0; i < subTotal.length(); i++) {
                writer.writeChar(subTotal.charAt(i));
            }
            currentState = context.getNextState(currentState, lexeme);
        }
        writer.close();
    }
    /**
     *
     * @return String
     */
    public final String getResult() {
       // bufferChar.setCharAt(bufferChar.length() - 1, ' ');
        return bufferChar.toString();
    }


}
