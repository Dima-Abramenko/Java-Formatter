package it.sevenbits.writer;

/**
 * writing Java-code.
 */
public class StringWriter implements IWriter<Character> {
    /**
     * comment.
     */
    private StringBuilder resultString = new StringBuilder();

    /**
     * entry method.
     * @param c comment.
     */
    public final void writeChar(final Character c) {
        resultString.append(c);
    }
    /**
     * entry method.
     */
    public final void close() {

    }
    /**
     * @return String.
     */
    public final String getResult() {
        resultString = resultString.deleteCharAt(resultString.length() - 1);
        return resultString.toString();
    }
}
