package it.sevenbits.formatter;

import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter{
    /**
     * entry method.
     */
    public void format(IReader reader, IWriter writer) throws IOException {
        while (reader.hasChar()) {
            char c = reader.readChar();
            //
            writer.writeChar(c);
        }
        writer.close();
    }
}
