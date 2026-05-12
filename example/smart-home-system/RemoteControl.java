package commandpattern;

/*
 * Invoker Class
 * -------------
 * This class is responsible for triggering commands.
 * 
 * Important:
 * The invoker does NOT know implementation details.
 * 
 * It does NOT know:
 * - how the light works
 * - how devices operate
 * - what business logic exists
 * 
 * It only knows:
 * 
 * command.execute();
 */
public class RemoteControl {
    
    
    /*
     * Current command assigned to the remote.
     */
    private Command command;
    
    
    /*
     * Stores the last executed command.
     * 
     * Used to support undo functionality.
     */
    private Command lastCommand;
    
    
    /*
     * setCommand()
     * -------------
     * Allows dynamic replacement of commands at runtime.
     * 
     * This gives the system flexibility.
     */
    public void setCommand(Command command){
        this.command = command;
    }
    
    
    /*
     * pressButton()
     * --------------
     * Executes the currently assigned command.
     * 
     * After execution:
     * the command is stored as the last command
     * to support undo functionality.
     */
    public void pressButton(){
        
        command.execute();
        
        lastCommand = command;
    }
    
    
    /*
     * pressUndo()
     * -------------
     * Reverses the last executed command.
     * 
     * Safety Check:
     * Ensures that a command exists before undoing.
     */
    public void pressUndo(){
        
        if(lastCommand != null){
            lastCommand.undo();
        }
    }
}
