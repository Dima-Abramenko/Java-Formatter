package it.sevenbits.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reading files.
 */
public class FileReader implements IReader<Character> {
    /**
     * needs to loop while.
     */
    private int character;
    /**
     * String for file's path.
     */
    private String inputURL;
    /**
     * BufferedReader for saving characters while reading.
     */
    private BufferedReader bufReader;
    /**
     *
     * @param input comment.
     */
    public FileReader(final String input) {
        inputURL = input;
        try {
            bufReader = new BufferedReader(new java.io.FileReader(inputURL));
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    /**
     *
     * @return Boolean.
     */
    public final boolean hasChar() {
        if (character == -1) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return char.
     */
    public final Character readChar() {
        try {
            character = bufReader.read();
        } catch (IOException e) {
            e.getMessage();
        }
        char c = (char) character;
        return c;
    }
}
