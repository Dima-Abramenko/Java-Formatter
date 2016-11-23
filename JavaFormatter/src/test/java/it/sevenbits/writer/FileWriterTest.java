package it.sevenbits.writer;

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
public class FileWriterTest {
    private IWriter writer;
    private IReader reader;
    private String outputURL;
    private  char text;
    @Before
    public void setUp() throws FileNotFoundException {
        outputURL = "src/main/resources/output.txt";
        writer = new FileWriter(outputURL);
        reader = new FileReader(outputURL);
        text = 'c';
        writer.writeChar('c');
        writer.close();
    }
    @Test
    public void testWriteFile() throws IOException {
        assertEquals(text, reader.readChar());
    }
}
