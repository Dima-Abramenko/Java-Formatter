package it.sevenbits.formatter;

import it.sevenbits.action.IAction;
import it.sevenbits.reader.IReader;
import it.sevenbits.state.Action;
import it.sevenbits.state.DefaultState;
import it.sevenbits.state.IState;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter<IReader, IWriter> {
    /**
     * needs to buffer last char.
     */
    private StringBuilder bufferChar = new StringBuilder();
    /**
     * entry method.
     * @param reader comment.
     * @param writer comment.
     */
    public final void format(final IReader reader, final IWriter writer) {
        IState currentState = new DefaultState();
        while (reader.hasChar()) {
            char c = (char) reader.readChar();
            Action action = new Action(currentState, c);
            String subTotal = action.getAction();
            for (int i = 0; i < subTotal.length(); i++) {
                writer.writeChar(subTotal.charAt(i));
            }
            currentState = action.getNextState(currentState, c);
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
