package it.sevenbits.chooser;

/**
 * Created by oem on 18.11.16.
 */
class ActionMarginFalse implements IChooser {
    /**
     * returns method.
     * @return String
     * @param current This is current symbol
     */
    public final String writeCode(final char current) {
        Selection.isMainCode = true;
        StringBuilder sb = new StringBuilder();
        //sb.append("\t");
        sb.append(current);
        return sb.toString();
    }
}
