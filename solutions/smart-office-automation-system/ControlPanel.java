package commandpattern;

/*
 * Invoker Class
 * -------------
 * Responsible for triggering commands.
 *
 * The control panel knows only:
 *
 * command.execute();
 */
public class ControlPanel {

    /*
     * Current command.
     */
    private Command command;

    /*
     * Last executed command.
     */
    private Command lastCommand;

    /*
     * Assigns a command dynamically.
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /*
     * Executes the assigned command.
     */
    public void pressButton() {

        command.execute();

        lastCommand = command;
    }

    /*
     * Reverses the last command.
     */
    public void pressUndo() {

        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}
