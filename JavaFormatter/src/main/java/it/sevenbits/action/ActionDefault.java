package it.sevenbits.action;

import it.sevenbits.writer.IWriter;

/**
 * Created by oem on 24.11.16.
 */
public class ActionDefault implements IAction {
    /**
     *
     * @param current comment.
     * @param writer comment.
     */
    public final void execute(final char current, final IWriter<Character> writer) {
        writer.writeChar(current);
    }
}
