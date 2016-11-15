package it.sevenbits.chooser;

import it.sevenbits.writer.IWriter;

/**
 * Created by oem on 15.11.16.
 */
public class ChooseClosingBrace implements IChooser{
    private IWriter writer;

    public ChooseClosingBrace(IWriter _writer) {
        writer = _writer;
    }
    /**
     * entry method
     */
    public void writingCode(char c) {
        writer.writeChar(c);
    }
}
