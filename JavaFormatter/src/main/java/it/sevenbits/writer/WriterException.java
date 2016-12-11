package it.sevenbits.writer;

import java.io.IOException;

/**
 * Created by oem on 11.12.16.
 */
public class WriterException extends Throwable {

    /**
     *
     * @param message comment.
     * @param e comment.
     */
    public WriterException(final String message, final IOException e) {
        super(message, e);
    }
}
