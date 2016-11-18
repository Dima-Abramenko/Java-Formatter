package it.sevenbits.formatter;

import it.sevenbits.chooser.*;
import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter {
    private StringBuilder bufferChar = new StringBuilder();
    private HashMap<String, IChooser> chooser = new HashMap<>();
    Selection choiceAction;

    public Formatter() throws FileNotFoundException {
        choiceAction = new Selection();
        choiceAction.init();
        chooser = choiceAction.getChooser();
    }

    /**
     * entry method.
     */
    public void format(final IReader reader, final IWriter writer) throws IOException {

        while (reader.hasChar()) {
            char c = reader.readChar();
            bufferChar.append(c);
            String subTotal = "";
            if (choiceAction.Test(bufferChar.length())) {
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
     * returns method
     */
    public String GetResult() {
        return bufferChar.toString();
    }
}
