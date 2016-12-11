package it.sevenbits.formatter;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.reader.FileReader;
import it.sevenbits.reader.IReader;
import it.sevenbits.reader.ReaderException;
import it.sevenbits.reader.StringReader;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;
import it.sevenbits.writer.StringWriter;
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
    private StringWriter writerFile;
    private Formatter formatter;;
    private final String inputString = "hello";
    private final String commentInLine = "//{FF{";
    private final String commentBlock = "/* ff{;dff*/";
    private final String stringLiteral = "\"Hello}\"";

    @Before
    public void setUp() throws FileNotFoundException {
        formatter = new Formatter();
    }
    @Test
    public void testFormatter() throws ReaderException {
        readerFile = new StringReader(inputString);
        writerFile =  new StringWriter();
        formatter.format(readerFile, writerFile);
        assertEquals("hello",writerFile.getResult() );
    }
    @Test
    public void testCommentInLine() throws ReaderException {
        readerFile = new StringReader(commentInLine);
        writerFile =  new StringWriter();
        formatter.format(readerFile, writerFile);
        assertEquals("//{FF{", writerFile.getResult() );
    }
    @Test
    public void testCommentBlock() throws ReaderException {
        readerFile = new StringReader(commentBlock);
        writerFile =  new StringWriter();
        formatter.format(readerFile, writerFile);
        assertEquals("/* ff{;dff*/", writerFile.getResult() );
    }
    @Test
    public void testStringLiteral() throws ReaderException {
        readerFile = new StringReader(stringLiteral);
        writerFile =  new StringWriter();
        formatter.format(readerFile, writerFile);
        assertEquals("\"Hello}\"", writerFile.getResult() );
    }
}
