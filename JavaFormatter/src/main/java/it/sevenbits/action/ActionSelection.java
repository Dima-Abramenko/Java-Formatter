package it.sevenbits.action;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by oem on 24.11.16.
 */
public class ActionSelection {
    /**
     * comment.
     */
    private HashMap<String, Character> mapActions;
    /**
     * entry method.
     * @throws FileNotFoundException comment.
     */
    public final void init() throws FileNotFoundException {
        mapActions = new HashMap<>();

        IAction actionDefault = new ActionDefault();




    }
}
