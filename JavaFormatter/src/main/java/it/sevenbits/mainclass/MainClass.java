package it.sevenbits.mainclass;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.formatter.IFormatter;
import it.sevenbits.reader.FileReader;
import it.sevenbits.reader.IReader;
import it.sevenbits.reader.StringReader;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;
import it.sevenbits.writer.StringWriter;

import java.io.IOException;

/**
 * main class of the project.
 */
public class MainClass {
    /**
     * Entry method.
     * @param args command line args, ignored.
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {
        final String inputURL = "src/main/resources/input.txt";
        final String outputURL = "src/main/resources/output.txt";
        final String inputString = "public static String reading(String fileName) throws IOException " +
                "{ String data; try (Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name()) " +
                "{ data = scanner.useDelimiter(//A).next(); } return data; }";

        Formatter formatter = new Formatter();

        IReader reader = new StringReader(inputString);
        IWriter writer = new StringWriter();
        formatter.format(reader, writer);

        IReader fileReader = new FileReader(inputURL);
        IWriter fileWriter = new FileWriter(outputURL);
        formatter.format(fileReader, fileWriter);

    }
}
