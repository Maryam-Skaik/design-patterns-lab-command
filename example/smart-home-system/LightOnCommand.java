package commandpattern;

/*
 * Concrete Command
 * ----------------
 * This class represents a specific executable request:
 * 
 * "Turn the light ON"
 * 
 * This command implements the Command interface,
 * which makes it interchangeable with other commands.
 */
public class LightOnCommand implements Command{
    
    
    /*
     * Reference to the Receiver object.
     * 
     * The command delegates work to the receiver.
     */
    private Light light;
    
    
    /*
     * Constructor Injection
     * ---------------------
     * The receiver object is injected into the command.
     * 
     * This creates loose coupling and flexibility.
     */
    public LightOnCommand(Light light){
        this.light = light;
    }

    
    /*
     * execute()
     * ----------
     * Executes the request by delegating the work
     * to the receiver.
     */
    @Override
    public void execute() {
        light.turnOn();
    }

    
    /*
     * undo()
     * -------
     * Reverses the previous action.
     * 
     * Since execute() turns the light ON,
     * undo() turns the light OFF.
     */
    @Override
    public void undo() {
        light.turnOff();
    }
    
}
