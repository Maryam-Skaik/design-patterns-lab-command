package commandpattern;

/*
 * Concrete Command
 * ----------------
 * Turns the office light ON.
 */
public class LightOnCommand implements Command {

    /*
     * Receiver Reference.
     */
    private Light light;

    /*
     * Constructor Injection.
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    /*
     * Executes the request.
     */
    @Override
    public void execute() {
        light.turnOn();
    }

    /*
     * Reverses the request.
     */
    @Override
    public void undo() {
        light.turnOff();
    }
}
