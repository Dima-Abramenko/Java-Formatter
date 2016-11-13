package it.sevenbits.formatter;

import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter{
     private StringBuilder resultCode = new StringBuilder();
     private static int codeNesting = 0;
     private  static int codeDepth = 0;
    /**
     * entry method.
     */
    public void format(IReader reader, IWriter writer) throws IOException {
        while (reader.hasChar()) {
            char c = reader.readChar();
            resultCode.append(c);
            if (c == '{') {
                writer.writeChar(c);
                writer.writeChar('\n');
                for(int i = 0; i < codeNesting; i++) {
                    writer.writeChar('\t');
                }
                codeNesting++;
            }
            else if (c == '}') {
                // to do smth with '}'
                writer.writeChar(c);
            }
            else if (c == ';') {
                writer.writeChar(c);
                writer.writeChar('\n');
                for(int i = 0; i < codeNesting-1; i++) {
                    writer.writeChar('\t');
                }
            }
            else {
                writer.writeChar(c);
            }

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
