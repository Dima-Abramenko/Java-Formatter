package it.sevenbits.reader;

import java.io.IOException;

/**
 * interface for reading.
 */
public interface IReader {
    /**
     * returns method.
     */
    boolean hasChar();
    /**
     * returns method.
     */
    char readChar() throws IOException;
}
