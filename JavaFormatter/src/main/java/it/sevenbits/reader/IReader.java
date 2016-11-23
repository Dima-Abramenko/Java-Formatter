package it.sevenbits.reader;

/**
 * interface for reading.
 * @param <T> comment.
 */
public interface IReader<T> {
    /**
     *
     * @return boolean.
     */
    boolean hasChar();

    /**
     *
     * @return char.
     */
    T readChar();
}
