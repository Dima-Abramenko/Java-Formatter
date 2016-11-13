package it.sevenbits.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  reading java-code out of the file.
 */
public class FileReader implements IReader {
    private int character;
    private String inputURL;
    private BufferedReader bufferedReader;
    public FileReader(String _inputURL) throws FileNotFoundException {
        inputURL = _inputURL;
        bufferedReader = new BufferedReader(new java.io.FileReader(inputURL));
    }
    /**
     * returns method.
     */
    public boolean hasChar() {
        if (character == -1) {
            return false;
        }
        return true;
    }
    /**
     * returns method.
     */
    public char readChar() throws IOException {
        character = bufferedReader.read();
        char c = (char) character;
        return c;
    }
}
