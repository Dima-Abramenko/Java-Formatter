package it.sevenbits.reader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by oem on 11.12.16.
 */
public class ReaderException extends Exception {
    /**
     *  @param message comment.
     * @param e comment.
     */
    public ReaderException(final String message, final ReaderException e) {
        super(message, e);
    }

    /**
     *
     * @param message comment.
     * @param e comment.
     */
    public ReaderException(final String message, final IOException e) {
        super(message, e);
    }

}
