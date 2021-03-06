package it.sevenbits.formatter;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.reader.*;
import it.sevenbits.token.IToken;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;
import it.sevenbits.writer.StringWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
/**
 * Created by oem on 14.11.16.
 */
public class FormatterTest {
    private StringReader readerFile;
    private IReader<IToken> lexer;
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
        lexer = new Lexer(readerFile);
        writerFile =  new StringWriter();
        formatter.format(lexer, writerFile);
        assertEquals("",  writerFile.getResult() );
    }

    @Test
    public void testCommentInLine() throws ReaderException {
        readerFile = new StringReader(commentInLine);
        lexer = new Lexer(readerFile);
        writerFile =  new StringWriter();
        formatter.format(lexer, writerFile);
        assertEquals("", writerFile.getResult() );
    }
    @Test
    public void testCommentBlock() throws ReaderException {
        readerFile = new StringReader(commentBlock);
        lexer = new Lexer(readerFile);
        writerFile =  new StringWriter();
        formatter.format(lexer, writerFile);
        assertEquals("", writerFile.getResult() );
    }

    @Test
    public void testStringLiteral() throws ReaderException {
        readerFile = new StringReader(stringLiteral);
        lexer = new Lexer(readerFile);
        writerFile =  new StringWriter();
        formatter.format(lexer, writerFile);
        assertEquals("", writerFile.getResult() );
    }
}
