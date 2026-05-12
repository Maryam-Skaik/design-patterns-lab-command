package commandpattern;

/*
 * Command Interface
 * -----------------
 * This is the core abstraction of the Command Pattern.
 * 
 * Every command in the system must implement this interface.
 * 
 * The purpose of this interface is to make all commands
 * interchangeable through polymorphism.
 * 
 * The invoker (RemoteControl) will depend ONLY on this
 * abstraction instead of concrete command classes.
 */
public interface Command {
    
    /*
     * execute()
     * ----------
     * Executes the required action/request.
     * 
     * Example:
     * - Turn light ON
     * - Turn TV OFF
     * - Open garage
     */
    void execute();
    
    
    /*
     * undo()
     * -------
     * Reverses the previously executed action.
     * 
     * Example:
     * If execute() turns light ON,
     * undo() should turn light OFF.
     */
    void undo();
}
