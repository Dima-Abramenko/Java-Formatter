package it.sevenbits.chooser;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;

/**
 * Created by oem on 15.11.16.
 */
public class ChooseOpeningBrace implements IChooser {

    IWriter writer;

    public ChooseOpeningBrace(IWriter _writer) throws FileNotFoundException {
        writer = _writer;
    }
    /**
     * entry method
     */
    public void writingCode(char c) {
        writer.writeChar(c);
        writer.writeChar('\n');
        for(int i = 0; i < Formatter.codeNesting; i++) {
            writer.writeChar('\t');
        }
        Formatter.codeNesting++;

    }
}
