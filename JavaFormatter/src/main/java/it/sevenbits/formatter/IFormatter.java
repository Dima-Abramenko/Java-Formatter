package it.sevenbits.formatter;

/**
 *
 * @param <T> comment.
 * @param <U> comment.
 */
public interface IFormatter<T, U> {
    /**
     *  entry method.
     * @param reader comment.
     * @param writer comment.
     */
    void format(final T reader, final U writer);
}
