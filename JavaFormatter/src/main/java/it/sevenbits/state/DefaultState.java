package it.sevenbits.state;

import it.sevenbits.action.Selection;
import it.sevenbits.action.ActionDefault;
import it.sevenbits.action.IAction;

import java.io.FileNotFoundException;
import java.util.HashMap;


/**
 * Created by oem on 04.12.16.
 */
public class DefaultState implements IState {
    /**
     * comment.
     */
    IAction currentAction;
    private HashMap<String, IAction> chooser;

    /**
     *
     * @param action comment.
     * @param c comment.
     * @return String.
     */
    public String getAction(final Action action, final char c) {
        Selection selection = new Selection();
        try {
            selection.init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        chooser = selection.getChooserAction();

        for(String s : chooser.keySet()) {
            if (s.equals(Character.toString(c))) {
                currentAction = chooser.get(s);
            } else {
                currentAction = new ActionDefault();
            }
        }
        return currentAction.execute(c);
    }
    public String getStateName() {
        return "DefaultState";
    }
}
