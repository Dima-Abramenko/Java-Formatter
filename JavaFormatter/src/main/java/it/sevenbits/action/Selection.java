package it.sevenbits.action;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by oem on 04.12.16.
 */
public class Selection {
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
    private HashMap<String, IAction> mapActions;

    /**
     *
     * @throws FileNotFoundException
     */
    public final void init() throws FileNotFoundException {
        IAction actionDefault = new ActionDefault();
        IAction actionOpBr = new ActionOpeningBrace();

        mapActions = new HashMap<>();
        mapActions.put("simple", actionDefault);
        mapActions.put("{", actionOpBr);
    }

    /**
     *
     * @return HashMap.
     */
    public final HashMap<String, IAction> getChooserAction() {
        return mapActions;
    }
}
