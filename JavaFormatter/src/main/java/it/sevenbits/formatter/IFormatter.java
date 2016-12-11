package it.sevenbits.formatter;

import it.sevenbits.reader.ReaderException;

/**
 *
 * @param <T> generic.
 * @param <U> generic.
 */
public interface IFormatter<T, U> {
    /**
     *
     * @param reader comment.
     * @param writer comment.
     * @throws ReaderException comment.
     */
    void format(final T reader, final U writer) throws ReaderException;
}
