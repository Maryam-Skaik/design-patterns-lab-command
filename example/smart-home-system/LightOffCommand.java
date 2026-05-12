package commandpattern;

/*
 * Concrete Command
 * ----------------
 * This class represents another executable request:
 * 
 * "Turn the light OFF"
 */
public class LightOffCommand implements Command{
    
    
    /*
     * Receiver Reference
     * ------------------
     * The command stores the receiver object
     * responsible for performing the actual work.
     */
    private Light light;
    
    
    /*
     * Constructor Injection
     * ---------------------
     * Injects the receiver object into the command.
     */
    public LightOffCommand(Light light){
        this.light = light;
    }

    
    /*
     * execute()
     * ----------
     * Executes the request:
     * Turn the light OFF.
     */
    @Override
    public void execute() {
        light.turnOff();
    }

    
    /*
     * undo()
     * -------
     * Reverses the previous action.
     * 
     * Since execute() turns the light OFF,
     * undo() turns the light ON.
     */
    @Override
    public void undo() {
        light.turnOn();
    }
}
