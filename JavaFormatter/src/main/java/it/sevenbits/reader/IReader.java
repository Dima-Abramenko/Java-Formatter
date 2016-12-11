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
    boolean hasMore();

    /**
     *
     * @return char.
     */
    T read() throws ReaderException;
}
