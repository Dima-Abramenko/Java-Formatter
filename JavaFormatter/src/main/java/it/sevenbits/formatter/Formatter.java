package it.sevenbits.formatter;

import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.initializator.Initializator;
import it.sevenbits.reader.IReader;
import it.sevenbits.reader.ReaderException;
import it.sevenbits.states.actionstate.ActionContext;
import it.sevenbits.states.actionstate.DefaultState;
import it.sevenbits.states.actionstate.IState;
import it.sevenbits.writer.IWriter;


/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter<IReader, IWriter> {
    /**
     * needs to buffer last char.
     */
    private StringBuilder bufferChar = new StringBuilder();
    /**
     * comment.
     */
    private Initializator init = new Initializator();
    /**
     * entry method.
     * @param reader comment.
     * @param writer comment.
     */
    /*
    public final void format(final IReader reader, IWriter writer)
            throws ReaderException {
        while (reader.hasMore()) {
            IToken token = (IToken) reader.read();
            String lexeme = token.getLexeme();
            // do smth
            String subTotal = "";
            for (int i = 0; i < subTotal.length(); i++) {
                writer.writeChar(subTotal.charAt(i));
            }
        }
        writer.close();
    }
        */

    /**
     *
     * @param reader interface for reading code.
     * @param writer interface for writing code.
     * @throws ReaderException comment.
     */

    public final void format(final IReader reader, final IWriter writer)
            throws ReaderException {
        IState currentState = new DefaultState();
        while (reader.hasMore()) {
            char c;
            try {
                c = (char) reader.read();
            } catch (ReaderException e) {
                throw new ReaderException("can not read", e);
            }
            ActionContext context = new ActionContext(currentState, c);
            IAction action = context.getAction();
            String subTotal = action.execute(c);
            for (int i = 0; i < subTotal.length(); i++) {
                writer.writeChar(subTotal.charAt(i));
            }
            currentState = context.getNextState(currentState, c);
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
