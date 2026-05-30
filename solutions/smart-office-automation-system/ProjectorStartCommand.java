package commandpattern;

/*
 * Concrete Command
 * ----------------
 * Starts the projector.
 */
public class ProjectorStartCommand implements Command {

    private Projector projector;

    public ProjectorStartCommand(Projector projector) {
        this.projector = projector;
    }

    @Override
    public void execute() {
        projector.start();
    }

    @Override
    public void undo() {
        projector.stop();
    }
}
