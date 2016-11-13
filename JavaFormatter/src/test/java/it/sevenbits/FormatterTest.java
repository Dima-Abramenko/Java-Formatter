package it.sevenbits;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.reader.FileReader;
import it.sevenbits.reader.IReader;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
/**
 * Created by oem on 14.11.16.
 */
public class FormatterTest {
    private IReader readerFile;
    private IWriter writerFile;
    private Formatter formatter;
    private String inputURL = "src/main/resources/input.txt";
    private String outputURL = "src/main/resources/output.txt";
    private final String inputString = "public static String reading(String fileName) throws IOException { String data; try (Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name()) { data = scanner.useDelimiter(\"\\\\A\").next(); } return data; } ";

    @Before
    public void setUp() throws FileNotFoundException {
        formatter = new Formatter();
    }
    @Test
    public void testFormatter() throws IOException {
        readerFile = new FileReader(inputURL);
        writerFile = new FileWriter(outputURL);
        formatter.format(readerFile, writerFile);
        assertEquals(inputString, formatter.GetResult());


    }
}
