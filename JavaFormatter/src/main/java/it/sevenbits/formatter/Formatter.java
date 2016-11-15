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
public class Formatter implements IFormatter{
    private StringBuilder resultCode = new StringBuilder();
    public static int codeNesting = 0;
    private HashMap <Character, IChooser> chooser = new HashMap<>();

    /**
     * entry method.
     */
    public void format(IReader reader, IWriter writer) throws IOException {
        Selection choosing = new Selection(writer);
        choosing.init();
        chooser = choosing.getChooser();
        while (reader.hasChar()) {
            char c = reader.readChar();
            resultCode.append(c);
            //
            chooser.get(c).writingCode(c);

        }
        writer.close();
        resultCode.setCharAt(resultCode.length()-1, ' ');
    }
    /**
     * returns method
     */
    public String GetResult() {
        return resultCode.toString();
    }
}
