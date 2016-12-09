package it.sevenbits.reader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * reading java-code out if the String variable.
 */
public class StringReader implements IReader<Character> {
    /**
     * comment.
     */
    private int character;
    /**
     * comment.
     */
    private String inputString;
    /**
     * comment.
     */
    private BufferedReader bufReader;

    /**
     * Constructor.
     * @param input comment.
     */
    public StringReader(final String input) {
        inputString = input;
        bufReader = new BufferedReader(new java.io.StringReader(inputString));
    }

    /**
     *
     * @return boolean.
     */

    public final boolean hasMore() {
       if (character == -1) {
           return false;
       }
       return true;
    }

    /**
     *
     * @return char.
     */
    public final Character read() {
        try {
            character = bufReader.read();
        } catch (IOException e) {
            e.getMessage();
        }
        char c = (char) character;
        return c;
    }
}
