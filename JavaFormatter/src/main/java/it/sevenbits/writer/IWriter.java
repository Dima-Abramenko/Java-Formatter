package it.sevenbits.writer;

/**
 * interface for writing in file.
 * @param <T> comment.
 */
public interface IWriter<T> {
    /**
     * entry method.
     * @param c comment.
     */
    void writeChar(T c);
    /**
     * entry method.
     */
    void close();
}
