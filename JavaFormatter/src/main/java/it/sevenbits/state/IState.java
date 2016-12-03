package it.sevenbits.state;

/**
 * Created by oem on 24.11.16.
 */
public interface IState {
    /**
     *
     * @return String.
     */
    String getAction(final Action action, final char c);
    String getStateName();
}
