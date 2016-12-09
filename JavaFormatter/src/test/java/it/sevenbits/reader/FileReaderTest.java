package it.sevenbits.reader;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
/**
 * Created by oem on 14.11.16.
 */
public class FileReaderTest {
    private IReader reader;
    private String inputURL;
    @Before
    public void setUp() throws FileNotFoundException {
        inputURL = "src/main/resources/input.txt";
        reader = new FileReader(inputURL);
    }
    @Test
    public void testReadFile() throws IOException {
        assertEquals(true, reader.hasMore());
        assertEquals('p', reader.read());
    }
}
