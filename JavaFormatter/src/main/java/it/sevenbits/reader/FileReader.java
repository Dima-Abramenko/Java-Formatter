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
     * @throws ReaderException comment.
     */
    public FileReader(final String input) throws ReaderException {
        inputURL = input;

        try {
            bufReader = new BufferedReader(new java.io.FileReader(inputURL));
        } catch (FileNotFoundException e) {
            throw new ReaderException("File not found", e);
        }

    }
    /**
     *
     * @return Boolean.
     */
    public final boolean hasMore() {
        if (character == -1) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Character.
     * @throws ReaderException comment.
     */
    public final Character read() throws ReaderException {

        try {
            character = bufReader.read();
        } catch (IOException e) {
            throw new ReaderException("Can not read", e);
        }

        char c = (char) character;
        return c;
    }
}
