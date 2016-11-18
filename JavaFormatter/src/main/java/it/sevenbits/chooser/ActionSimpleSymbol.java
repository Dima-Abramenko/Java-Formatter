package it.sevenbits.chooser;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;

/**
 * Created by oem on 15.11.16.
 */
public class ActionSimpleSymbol implements IChooser {
    /**
     * returns method
     */
    public String writeCode(final char current) {

        return Character.toString(current);

    }
}
