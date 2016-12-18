package it.sevenbits.initializator;

import it.sevenbits.actions.formatter.ActionSemicolon;
import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.ActionOpeningBrace;
import it.sevenbits.actions.formatter.ActionClosingBrace;
import it.sevenbits.actions.lexer.ActionLexerSeparator;
import it.sevenbits.actions.lexer.ActionLexerDefault;
import it.sevenbits.actions.lexer.ActionLexerSkip;
import it.sevenbits.actions.lexer.IActionLexer;
import it.sevenbits.states.actionstate.ForState;
import it.sevenbits.states.actionstate.IState;
import it.sevenbits.states.actionstate.DefaultState;
import it.sevenbits.states.lexerstate.BlockCommentLexerState;
import it.sevenbits.states.lexerstate.CommentLexerState;
import it.sevenbits.states.lexerstate.DefaultLexerState;
import it.sevenbits.states.lexerstate.EndCommentLexerState;
import it.sevenbits.states.lexerstate.InLineCommentLexerState;
import it.sevenbits.states.lexerstate.IStateLexer;
import it.sevenbits.states.lexerstate.StringLexerState;


import java.util.HashMap;

/**
 * Created by oem on 09.12.16.
 */
public class Initializator {
    /**
     *  comment.
     */
    public static int rightMargin = 0;
    /**
     * comment.
     */
    public static HashMap<String, IAction> mapActions;
    /**
     * comment.
     */
    public static HashMap<String, IState> mapTransitions;
    /**
     * comment.
     */
    public static HashMap<String, IActionLexer> mapLexerActions;
    /**
     * comment.
     */
    public static HashMap<String, IStateLexer> mapLexerTransition;
    /**
     * comment.
     */
    public static boolean isEnd = false;
    /**
     *
     */
    public Initializator() {
        // отображение действий форматтера.
        IAction actionDefault = new ActionDefault();
        IAction actionOpBr = new ActionOpeningBrace();
        IAction actionClBr = new ActionClosingBrace();
        IAction actionSem = new ActionSemicolon();
        mapActions = new HashMap<>();
        mapActions.put("simple", actionDefault);
        mapActions.put("{", actionOpBr);
        mapActions.put("}", actionClBr);
        mapActions.put(";", actionSem);
        // отображение перехода состояний форматтера.
        mapTransitions = new HashMap<>();
        mapTransitions.put("defaultfor", new ForState());
        mapTransitions.put("for)", new DefaultState());
        // отображение действий лексера.
        IActionLexer defaultAction = new ActionLexerDefault();
        IActionLexer skipAction = new ActionLexerSkip();
        IActionLexer separator = new ActionLexerSeparator();
        mapLexerActions = new HashMap<>();
        mapLexerActions.put(" ", skipAction);
        mapLexerActions.put("\n", skipAction);
        mapLexerActions.put("\t", skipAction);
        mapLexerActions.put(";", separator);
        mapLexerActions.put("(", separator);
        mapLexerActions.put(")", separator);
        mapLexerActions.put(",", separator);

        mapLexerActions.put("simple", defaultAction);
        // отображение перехода состояний лексера.
        mapLexerTransition = new HashMap<>();
        mapLexerTransition.put("default/", new CommentLexerState());
        mapLexerTransition.put("comment/", new InLineCommentLexerState());
        mapLexerTransition.put("comment*", new BlockCommentLexerState());
        mapLexerTransition.put("inline\n", new DefaultLexerState());
        mapLexerTransition.put("block*", new EndCommentLexerState());
        mapLexerTransition.put("endcomment/", new DefaultLexerState());
        mapLexerTransition.put("default\"", new StringLexerState());
        mapLexerTransition.put("string\"", new DefaultLexerState());
    }
}
