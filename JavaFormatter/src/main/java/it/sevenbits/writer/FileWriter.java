package it.sevenbits.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *  writing formatted java-code in file.
 */
public class FileWriter implements IWriter {
    private String outputURL;
    private PrintWriter printWriter;
    private File file;

    public FileWriter(String _outputURL) throws FileNotFoundException {
        outputURL = _outputURL;
        file = new File(outputURL);
        printWriter = new PrintWriter(file.getAbsolutePath());
    }
    /**
     * entry method.
     */
    public void writeChar(char c) {
        printWriter.print(c);
    }
    /**
     * entry method.
     */
    public void close() {
        printWriter.close();
    }
}
