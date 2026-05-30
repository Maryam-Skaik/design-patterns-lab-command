package commandpattern;

/*
 * Concrete Command
 * ----------------
 * Turns the office light OFF.
 */
public class LightOffCommand implements Command {

    /*
     * Receiver Reference.
     */
    private Light light;

    /*
     * Constructor Injection.
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /*
     * Executes the request.
     */
    @Override
    public void execute() {
        light.turnOff();
    }

    /*
     * Reverses the request.
     */
    @Override
    public void undo() {
        light.turnOn();
    }
}
