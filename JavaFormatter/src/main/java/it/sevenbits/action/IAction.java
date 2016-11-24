package it.sevenbits.action;

import it.sevenbits.writer.IWriter;

/**
 * Created by oem on 24.11.16.
 */
public interface IAction {
    /**
     *
     * @param current comment.
     * @param writer comment.
     */
    void execute(final char current, IWriter<Character> writer);
}
