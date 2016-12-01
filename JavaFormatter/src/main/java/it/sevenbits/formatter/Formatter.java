package it.sevenbits.formatter;

import it.sevenbits.action.ActionSelection;
import it.sevenbits.action.IAction;
import it.sevenbits.chooser.Selection;
import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * formatting input java-code.
 */
public class Formatter implements IFormatter<IReader, IWriter> {
    /**
     * needs to buffer last char.
     */
    private StringBuilder bufferChar = new StringBuilder();
    /**
     *  map for choosing current Action.
     */
    private HashMap<String, String> chooser = new HashMap<>();
    /**
     * comment.
     */
    private HashMap<String, IAction> mapChooser = new HashMap<>();
    /**
     *  Selection class object, it is init all actions.
     */
    private Selection choiceAction;
    /**
     *  comment.
     */
    private ActionSelection actSel;

    /**
     * comment.
     * @throws FileNotFoundException comment.
     */
    public Formatter() throws FileNotFoundException {
        choiceAction = new Selection();
        choiceAction.init();
        //chooser = choiceAction.getChooser();
        actSel = new ActionSelection();
        actSel.init();
        mapChooser = actSel.getChooserAction();
        chooser = actSel.getChooserState();
    }

    /**
     * entry method.
     * @param reader comment.
     * @param writer comment.
     */
    public final void format(final IReader reader, final IWriter writer) {
        String currentState = "default";
        while (reader.hasChar()) {
            char c = (char) reader.readChar();
            IAction action = mapChooser.get(actSel.getAction(currentState, c));
            String subTotal = action.execute(c);
            char[] buffer = subTotal.toCharArray();
            for (char i : buffer) {
                writer.writeChar(i);
            }
            currentState = chooser.get(actSel.getNextState(currentState, c));
            /*
            bufferChar.append(c);
            String subTotal = "";

            if (choiceAction.test(bufferChar.length())) {
                subTotal = chooser.get(choiceAction.getAction(c, bufferChar.charAt(bufferChar.length() - 2))).writeCode(c);
            } else {
                writer.writeChar(c);
            }
            char[] buffer = subTotal.toCharArray();
            for (char i : buffer) {
                writer.writeChar(i);
            }
*/
        }

        writer.close();
    }

    /**
     *
     * @return String
     */
    public final String getResult() {
       // bufferChar.setCharAt(bufferChar.length() - 1, ' ');
        return bufferChar.toString();
    }


}
