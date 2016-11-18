package it.sevenbits.chooser;



import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by oem on 16.11.16.
 */
public class Selection {
    private HashMap<String, IChooser> mainText;
    public static int rightMargin = 0;
    public static boolean isMainCode = true;
    public static boolean isStringLine = false;
    /**
     * entry method
     * @throws FileNotFoundException
     */
    public void init() throws FileNotFoundException {
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
        IChooser stringLineEnd= new ActionStringLineEnd();

        Pattern brInLine = Pattern.compile("\\{.");
        Pattern brNewLine = Pattern.compile("\\{\\n");
        Pattern marginF = Pattern.compile("\\n[^\\t]");
        Pattern marginT = Pattern.compile("\\n\\t");
        Pattern SemInLine = Pattern.compile(";.");
        Pattern SemNewLine = Pattern.compile(";\\n");
        Pattern commInLine = Pattern.compile("//");
        Pattern CommStLine = Pattern.compile("/\\*");
        Pattern CommEndLine = Pattern.compile("\\*/");
        Pattern StrLineBegin = Pattern.compile("[ (=]\"");
        Pattern StrLineEnd = Pattern.compile("\"[ )]");

        mainText.put("simple", simpleSymbol);
        mainText.put(brInLine.toString(), braceInLine);
        mainText.put(brNewLine.toString(), braceNewLine);
        mainText.put(marginF.toString(), marginFalse);
        mainText.put(marginT.toString(), marginTrue);
        mainText.put(SemInLine.toString(), semicolonInLine);
        mainText.put(SemNewLine.toString(), semicolonNewLine);
        mainText.put(commInLine.toString(), commentsInLine);
        mainText.put(CommStLine.toString(), commentsStartLine);
        mainText.put(CommEndLine.toString(), commentsEndLine);
        mainText.put(StrLineBegin.toString(), stringLineBegin);
        mainText.put(StrLineEnd.toString(), stringLineEnd);

    }
    public String getAction(char currentChar, char previousChar) {
        String buff = Character.toString(previousChar) + Character.toString(currentChar);
        for(String s : mainText.keySet()) {
            if (buff.matches(s)) {
                return s;
            }
        }
        return "simple";
    }
    public Boolean Test(int bufferLength) {
        if (bufferLength >= 2){
            return true;
        }
        return false;
    }
    public HashMap<String, IChooser> getChooser() {
        return mainText;
    }
}
