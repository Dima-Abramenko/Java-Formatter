package it.sevenbits.formatter;

import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * interface for formatting.
 */
public interface IFormatter {
    /**
     * entry method.
     */
    void format(final IReader reader, final IWriter writer) throws IOException;
}
