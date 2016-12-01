package it.sevenbits.action;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by oem on 24.11.16.
 */
public class ActionSelection {
    /**
     * comment.
     */
    static int rightMargin = 0;
    /**
     * comment.
     */
    static boolean isMainCode = true;
    /**
     * comment.
     */
    static boolean isComment = false;
    /**
     * comment.
     */
    private HashMap<String, String> mapActionsCases;
    /**
     * comment.
     */
    private HashMap<String, IAction> mapActions;
    /**
     * comment.
     */
    private HashMap<String, String> mapStates;
    /**
     * comment.
     */
    private HashMap<String, String> mapTransition;
    /**
     * entry method.
     * @throws FileNotFoundException comment.
     */
    public final void init() throws FileNotFoundException {
        IAction actionDefault = new ActionDefault();
        IAction actionOpBr = new ActionOpeningBrace();
        IAction actionClBr = new ActionClosingBrace();
        IAction actionSemCol = new ActionSemicolon();
        mapActionsCases = new HashMap<>();
        mapActions = new HashMap<>();
        mapStates = new HashMap<>();
        mapTransition = new HashMap<>();

        // отображение всех действий.
        mapActions.put("simple-default", actionDefault);
        mapActions.put("simple-stringLiteral", actionDefault);
        mapActions.put("simple-comment", actionDefault);
        mapActions.put("simple-commentInLine", actionDefault);
        mapActions.put("{", actionOpBr);
        mapActions.put("}", actionClBr);
        mapActions.put(";", actionSemCol);

        // отображение связи действия от состояния.
        mapActionsCases.put("simple-default", "default");
        mapActionsCases.put("simple-stringLiteral", "stringLiteral");
        mapActionsCases.put("simple-comment", "comment");
        mapActionsCases.put("simple-commentInLine", "commentInLine");
        mapActionsCases.put("{", "default");
        mapActionsCases.put("}", "default");
        mapActionsCases.put(";", "default");

        // отображение переходов состояний.
        mapStates.put("default", "default");
        mapStates.put("default\"", "stringLiteral");
        mapStates.put("stringLiteral\"", "default");
        mapStates.put("default/", "comment");
        mapStates.put("comment/", "commentInline");
        mapStates.put("CommentInLine\n", "default");

    }

    /**
     *
     * @param state comment.
     * @param current comment.
     * @return String.
     */
    public final String getAction(final String state, final char current) {
        String currentState = "";
        for (Map.Entry entry : mapActionsCases.entrySet()) {
            if (state == entry.getValue()) {
                currentState = state;
                for (String s : mapActions.keySet()) {
                    if (s.endsWith(Character.toString(current))) {
                        return s;
                    }
                }
            }
        }
        return "simple-" + currentState;
    }

    /**
     *
     * @param state comment.
     * @param current comment.
     * @return String.
     */
    public final String getNextState(final String state, final char current) {
        String buffer = state + Character.toString(current);
        if (Objects.equals(buffer, "default\"")) {
            if (isMainCode) {
                isMainCode = false;
            } else {
                isMainCode = true;
            }
            return "default\"";
        }
        return "default";
    }

    /**
     * @return HashMap
     */
    public final HashMap<String, IAction> getChooserAction() {
        return mapActions;
    }

    /**
     * @return HashMap
     */
    public final HashMap<String, String> getChooserState() {
        return mapStates;
    }
}
