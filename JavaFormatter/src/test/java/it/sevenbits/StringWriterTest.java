package it.sevenbits;

import it.sevenbits.writer.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by oem on 13.11.16.
 */
public class StringWriterTest {
    private StringWriter writer;
    private  String text;
    @Before
    public void setUp() {
        writer = new StringWriter();
        text = "c";
        writer.writeChar('c');
    }
    @Test
    public void testWrite() {
        assertEquals(text, writer.getResult());
    }
}
