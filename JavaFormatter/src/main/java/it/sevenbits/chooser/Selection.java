package it.sevenbits.chooser;

import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by oem on 16.11.16.
 */
public class Selection {
    private IWriter writer;
    private HashMap<Character, IChooser> chooser;
    public Selection(IWriter _writer) {
        writer = _writer;
    }
    public void init() throws FileNotFoundException {
        chooser = new HashMap<>();
        IChooser openingBrace = new ChooseOpeningBrace(writer);
        IChooser closingBrace = new ChooseClosingBrace(writer);
        IChooser simpleSemicolon  = new ChooseSimpleSemicolon(writer);
        IChooser simpleSymbol = new ChooseSimpleSymbol(writer);
        for (int i = -1; i<=127; i++) {
            chooser.put((char)i,simpleSymbol);
        }
        chooser.put('{', openingBrace);
        chooser.put('}', closingBrace );
        chooser.put(';', simpleSemicolon);
    }
    public HashMap<Character, IChooser> getChooser() {
        return chooser;
    }
}
