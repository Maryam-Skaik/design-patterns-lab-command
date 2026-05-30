package commandpattern;

/*
 * Concrete Command
 * ----------------
 * Starts the coffee machine.
 */
public class CoffeeMachineStartCommand implements Command {

    private CoffeeMachine coffeeMachine;

    public CoffeeMachineStartCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute() {
        coffeeMachine.start();
    }

    @Override
    public void undo() {
        coffeeMachine.stop();
    }
}
