package it.sevenbits.mainclass;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.reader.FileReader;
import it.sevenbits.reader.IReader;
import it.sevenbits.state.*;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * main class of the project.
 */
 class MainClass {
    /**
     * Entry method.
     * @param args command line args, ignored.
     * @throws IOException comment.
     */
    public static void main(final String[] args) throws IOException {
        final String inputURL = "src/main/resources/input.txt";
        final String outputURL = "src/main/resources/output.txt";

        Formatter formatter = new Formatter();

        IReader fileReader = new FileReader(inputURL);
        IWriter fileWriter = new FileWriter(outputURL);
        formatter.format(fileReader, fileWriter);
        System.out.println(formatter.getResult());




    }
}
