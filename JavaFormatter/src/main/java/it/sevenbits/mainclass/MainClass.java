package it.sevenbits.mainclass;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.reader.FileReader;
import it.sevenbits.reader.IReader;
import it.sevenbits.reader.Lexer;
import it.sevenbits.reader.ReaderException;
import it.sevenbits.token.IToken;
import it.sevenbits.writer.FileWriter;
import it.sevenbits.writer.IWriter;
import it.sevenbits.writer.WriterException;
/**
 * main class of the project.
 */
 class MainClass {
    /**
     *
     * @param args comment.
     * @throws ReaderException comment.
     * @throws WriterException comment.
     */
    public static void main(final String[] args)
            throws ReaderException, WriterException {
        final String inputURL = "src/main/resources/input.txt";
        final String outputURL = "src/main/resources/output.txt";

        Formatter formatter = new Formatter();
        IReader<Character> fileReader = new FileReader(inputURL);
        IWriter<Character> fileWriter = new FileWriter(outputURL);
        IReader<IToken> lexer = new Lexer(fileReader);
        //formatter.format(lexer, fileWriter);
        formatter.format(fileReader, fileWriter);
        System.out.println(formatter.getResult());




    }
}
