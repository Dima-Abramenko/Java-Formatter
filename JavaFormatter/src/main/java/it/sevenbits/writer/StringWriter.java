package it.sevenbits.writer;

/**
 * writing Java-code.
 */
public class StringWriter implements IWriter {
    public StringBuilder resultString = new StringBuilder();
    /**
     * entry method.
     */

    public void writeChar(char c) {
        resultString.append(c);
    }
    /**
     * entry method.
     */
    public void close() {

    }
}
