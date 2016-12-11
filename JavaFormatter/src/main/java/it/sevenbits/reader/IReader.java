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
     * @return T
     * @throws ReaderException comment.
     */
    T read() throws ReaderException;
}
