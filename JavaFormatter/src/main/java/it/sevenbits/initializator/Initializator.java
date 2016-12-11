package it.sevenbits.initializator;

import it.sevenbits.actions.formatter.ActionSemicolon;
import it.sevenbits.actions.formatter.IAction;
import it.sevenbits.actions.formatter.ActionDefault;
import it.sevenbits.actions.formatter.ActionOpeningBrace;
import it.sevenbits.actions.formatter.ActionClosingBrace;
import it.sevenbits.actions.lexer.ActionLexerComment;
import it.sevenbits.actions.lexer.ActionLexerDefault;
import it.sevenbits.actions.lexer.ActionLexerSkip;
import it.sevenbits.actions.lexer.IActionLexer;
import it.sevenbits.states.actionstate.IState;
import it.sevenbits.states.actionstate.BlockComState;
import it.sevenbits.states.actionstate.CommentState;
import it.sevenbits.states.actionstate.DefaultState;
import it.sevenbits.states.actionstate.EndBlockComState;
import it.sevenbits.states.actionstate.InLineComState;
import it.sevenbits.states.actionstate.StringLiteralState;
import it.sevenbits.states.lexerstate.InLineCommentLexerState;
import it.sevenbits.states.lexerstate.EndCommentLexerState;
import it.sevenbits.states.lexerstate.CommentLexerState;
import it.sevenbits.states.lexerstate.BlockCommentLexerState;
import it.sevenbits.states.lexerstate.DefaultLexerState;
import it.sevenbits.states.lexerstate.IStateLexer;

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
        mapTransitions.put("DefaultState\"", new StringLiteralState());
        mapTransitions.put("DefaultState/", new CommentState());
        mapTransitions.put("Str\"", new DefaultState());
        mapTransitions.put("Comm/", new InLineComState());
        mapTransitions.put("Comm*", new BlockComState());
        mapTransitions.put("Block*", new EndBlockComState());
        mapTransitions.put("InLine\n", new DefaultState());
        mapTransitions.put("End/", new DefaultState());
        // отображение действий лексера.
        IActionLexer defaultAction = new ActionLexerDefault();
        IActionLexer commentAction = new ActionLexerComment();
        IActionLexer skipAction = new ActionLexerSkip();
        mapLexerActions = new HashMap<>();
        mapLexerActions.put(" ", skipAction);
        mapLexerActions.put("\n", skipAction);
        mapLexerActions.put("\t", skipAction);
        mapLexerActions.put("simple", defaultAction);
        // отображение перехода состояний лексера.
        mapLexerTransition = new HashMap<>();
        mapLexerTransition.put("default/", new CommentLexerState());
        mapLexerTransition.put("comment/", new InLineCommentLexerState());
        mapLexerTransition.put("comment*", new BlockCommentLexerState());
        mapLexerTransition.put("inline\n", new DefaultLexerState());
        mapLexerTransition.put("block*", new EndCommentLexerState());
        mapLexerTransition.put("endcomment/", new DefaultLexerState());
    }
}
