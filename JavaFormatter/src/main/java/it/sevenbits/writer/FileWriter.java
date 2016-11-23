package it.sevenbits.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *  writing formatted java-code in file.
 */
public class FileWriter implements IWriter<Character> {
    /**
     * comment.
     */
    private String outputURL;
    /**
     * comment.
     */
    private PrintWriter printWriter;
    /**
     * comment.
     */
    private File file;

    /**
     *
     * @param output comment.
     */
    public FileWriter(final String output) {
        outputURL = output;
        file = new File(outputURL);
        try {
            printWriter = new PrintWriter(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    /**
     * entry method.
     * @param c comment.
     */
    public final void writeChar(final Character c) {
        printWriter.print(c);
    }

    /**
     * entry method.
     */
    public final void close() {
        printWriter.close();
    }
}
