package it.sevenbits.reader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * reading java-code out if the String variable.
 */
public class StringReader implements IReader {
    private int character;
    private String inputString;
    private BufferedReader bufferedReader;

    public StringReader(String _input) {
        inputString = _input;
        bufferedReader = new BufferedReader(new java.io.StringReader(inputString));
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
