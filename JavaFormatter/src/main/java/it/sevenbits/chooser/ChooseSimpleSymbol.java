package it.sevenbits.chooser;

import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;

/**
 * Created by oem on 15.11.16.
 */
public class ChooseSimpleSymbol implements IChooser{
    private IWriter writer;

    public ChooseSimpleSymbol(IWriter _writer) throws FileNotFoundException {
        writer = _writer;
    }
    /**
     * entry method
     */
    public void writingCode(char c) {
        writer.writeChar(c);

    }
}
