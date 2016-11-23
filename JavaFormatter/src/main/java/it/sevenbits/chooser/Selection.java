package it.sevenbits.chooser;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by oem on 16.11.16.
 */
public class Selection {
    /**
     * comment.
     */
    private HashMap<String, IChooser> mainText;
    /**
     * comment.
     */
    private HashMap<String, IChooser> text;
    /**
     * comment.
     */
    public static int rightMargin = 0;
    /**
     * comment.
     */
    public static boolean isMainCode = true;
    /**
     * comment.
     */
    public static boolean isStringLine = false;

    /**
     * entry method.
     * @throws FileNotFoundException comment.
     */
     public final void init() throws FileNotFoundException {
        mainText = new HashMap<>();
        IChooser simpleSymbol = new ActionSimpleSymbol();
        IChooser braceInLine = new ActionBraceInLine();
        IChooser braceNewLine = new ActionBraceNewLine();
        IChooser marginFalse = new ActionMarginFalse();
        IChooser marginTrue = new ActionMarginTrue();
        IChooser semicolonInLine = new ActionSemicolonInLine();
        IChooser semicolonNewLine = new ActionSemicolonNewLine();
        IChooser commentsInLine = new ActionCommentsInLine();
        IChooser commentsStartLine = new ActionCommentsStartLine();
        IChooser commentsEndLine = new ActionCommentsEndLine();
        IChooser stringLineBegin = new ActionStringLineBegin();
        IChooser stringLineEnd = new ActionStringLineEnd();
        IChooser closingBraceNewLine = new ActionClosingBraceNewLine();

        mainText.put("simple", simpleSymbol);
        mainText.put("\\{.", braceInLine);
        mainText.put("\\{\\n", braceNewLine);
        mainText.put("\\n[^\\t]", marginFalse);
        mainText.put("\\n\\t", marginTrue);
        mainText.put(";.", semicolonInLine);
        mainText.put(";\\n", semicolonNewLine);
        mainText.put("//", commentsInLine);
        mainText.put("/\\*", commentsStartLine);
        mainText.put("\\*/", commentsEndLine);
        mainText.put("[ (=]\"", stringLineBegin);
        mainText.put("\"[ )]", stringLineEnd);
        mainText.put("}\\n", closingBraceNewLine);

    }

    /**
     *
     * @param curCh comment.
     * @param prevCh comment.
     * @return String
     */
    public final String getAction(final char curCh, final char prevCh) {
        String buff = Character.toString(prevCh) + Character.toString(curCh);
        for (String s : mainText.keySet()) {
            if (buff.matches(s)) {
                return s;
            }
        }
        return "simple";
    }

    /**
     *
     * @param bufferLength comment
     * @return Boolean
     */
    public final Boolean test(final int bufferLength) {
        if (bufferLength >= 2) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return HashMap
     */
    public final HashMap<String, IChooser> getChooser() {
        return mainText;
    }
}
