package commandpattern;

/*
 * Client Class
 * ------------
 * Wires all components together.
 */
public class Main {

    public static void main(String[] args) {

        /*
         * Step 1:
         * Create receiver objects.
         */
        Light light = new Light();

        Projector projector = new Projector();

        AC ac = new AC();

        CoffeeMachine coffeeMachine = new CoffeeMachine();


        /*
         * Step 2:
         * Create command objects.
         */
        Command lightOn = new LightOnCommand(light);

        Command projectorStart =
                new ProjectorStartCommand(projector);

        Command acStart =
                new ACStartCommand(ac);

        Command coffeeStart =
                new CoffeeMachineStartCommand(coffeeMachine);


        /*
         * Step 3:
         * Create invoker.
         */
        ControlPanel panel = new ControlPanel();


        /*
         * Step 4:
         * Turn lights ON.
         */
        System.out.println("Turning Lights ON");

        panel.setCommand(lightOn);

        panel.pressButton();

        System.out.println("-------------------------");


        /*
         * Step 5:
         * Start projector.
         */
        System.out.println("Starting Projector");

        panel.setCommand(projectorStart);

        panel.pressButton();

        System.out.println("-------------------------");


        /*
         * Step 6:
         * Start coffee machine.
         */
        System.out.println("Starting Coffee Machine");

        panel.setCommand(coffeeStart);

        panel.pressButton();

        System.out.println("-------------------------");


        /*
         * Step 7:
         * Start AC.
         */
        System.out.println("Starting AC");

        panel.setCommand(acStart);

        panel.pressButton();

        System.out.println("-------------------------");


        /*
         * Step 8:
         * Undo last operation.
         */
        System.out.println("Undo Last Command");

        panel.pressUndo();
    }
}
