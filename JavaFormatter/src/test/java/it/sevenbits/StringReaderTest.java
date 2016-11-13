package it.sevenbits;

import it.sevenbits.reader.IReader;
import it.sevenbits.reader.StringReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
/**
 * Created by oem on 13.11.16.
 */
public class StringReaderTest {
    private IReader reader;
    @Before
    public void setUp() {
        reader = new StringReader("hello");
    }
    @Test
    public void testRead() throws IOException {
        assertEquals(true, reader.hasChar());
        assertEquals('h', reader.readChar());
    }

}
