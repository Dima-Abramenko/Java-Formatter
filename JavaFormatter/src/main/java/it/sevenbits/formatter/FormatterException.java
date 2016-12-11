package it.sevenbits.formatter;

import it.sevenbits.reader.ReaderException;
import it.sevenbits.writer.WriterException;

/**
 * Created by oem on 11.12.16.
 */
public class FormatterException extends Throwable {
    /**
     *
     * @param message comment.
     * @param e comment.
     */
    public FormatterException(final String message, final ReaderException e) {
        super(message, e);
    }

    /**
     *
     * @param message comment.
     * @param e comment.
     */
    public FormatterException(final String message, final WriterException e) {
        super(message, e);
    }
}
