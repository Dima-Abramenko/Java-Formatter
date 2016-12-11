package it.sevenbits.formatter;

import it.sevenbits.reader.ReaderException;

/**
 *
 * @param <T> generic.
 * @param <U> generic.
 */
public interface IFormatter<T, U> {
    /**
     *  entry method.
     * @param reader interface for reading code.
     * @param writer interface for writing code.
     */
    void format(final T reader, final U writer) throws ReaderException;
}
