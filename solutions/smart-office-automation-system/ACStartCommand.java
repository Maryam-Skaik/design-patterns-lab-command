package commandpattern;

/*
 * Concrete Command
 * ----------------
 * Starts the AC.
 */
public class ACStartCommand implements Command {

    private AC ac;

    public ACStartCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.start();
    }

    @Override
    public void undo() {
        ac.stop();
    }
}
