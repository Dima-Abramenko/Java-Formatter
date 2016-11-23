package it.sevenbits.formatter;

import it.sevenbits.chooser.IChooser;
import it.sevenbits.chooser.Selection;
import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter<IReader, IWriter> {
    /**
     * comment.
     */
    private StringBuilder bufferChar = new StringBuilder();
    /**
     * comment.
     */
    private HashMap<String, IChooser> chooser = new HashMap<>();
    /**
     * comment.
     */
    private Selection choiceAction;

    /**
     * Formatter.
     *
     */
    public Formatter() {
        choiceAction = new Selection();
        try {
            choiceAction.init();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        chooser = choiceAction.getChooser();
    }

    /**
     * entry method.
     * @param reader comment.
     * @param writer comment.
     */
    public final void format(final IReader reader, final IWriter writer) {

        while (reader.hasChar()) {
            char c = (char) reader.readChar();

            bufferChar.append(c);
            String subTotal = "";
            if (choiceAction.test(bufferChar.length())) {
                subTotal = chooser.get(choiceAction.getAction(c, bufferChar.charAt(bufferChar.length() - 2))).writeCode(c);
            } else {
                writer.writeChar(c);
            }
            char[] buffer = subTotal.toCharArray();
            for (char i : buffer) {
                writer.writeChar(i);
            }

        }

        writer.close();
    }

    /**
     * retutn method.
     * @return String
     */
    public final String getResult() {
        bufferChar.setCharAt(bufferChar.length() - 1, ' ');
        return bufferChar.toString();
    }


}
