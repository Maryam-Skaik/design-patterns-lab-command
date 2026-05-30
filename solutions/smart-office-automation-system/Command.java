package commandpattern;

/*
 * Command Interface
 * -----------------
 * Core abstraction of the Command Pattern.
 *
 * Every command must implement this interface.
 *
 * The invoker depends only on this abstraction.
 */
public interface Command {

    /*
     * Executes the requested action.
     */
    void execute();

    /*
     * Reverses the previously executed action.
     */
    void undo();
}
