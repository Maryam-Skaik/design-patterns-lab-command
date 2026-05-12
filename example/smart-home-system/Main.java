package commandpattern;

/*
 * Client Class
 * ------------
 * This class is responsible for:
 * 
 * - Creating receiver objects
 * - Creating command objects
 * - Assigning commands to the invoker
 * - Running the system
 * 
 * The client wires all components together.
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        /*
         * Step 1:
         * Create the Receiver object.
         * 
         * The receiver performs the actual work.
         */
        Light light = new Light();
        
        
        /*
         * Step 2:
         * Create Concrete Command objects.
         * 
         * Each command receives the receiver object.
         */
        Command lightOn = new LightOnCommand(light);
        
        Command lightOff = new LightOffCommand(light);
        
        
        /*
         * Step 3:
         * Create the Invoker object.
         */
        RemoteControl remote = new RemoteControl();
        
        
        /*
         * Step 4:
         * Assign and execute Light ON command.
         */
        System.out.println("Turning Light On");
        
        remote.setCommand(lightOn);
        
        remote.pressButton();
        
        System.out.println("---------------------------");
        
        
        /*
         * Step 5:
         * Undo the previous command.
         */
        System.out.println("Undo Last Command");
        
        remote.pressUndo();
        
        System.out.println("---------------------------");
        
        
        /*
         * Step 6:
         * Assign and execute Light OFF command.
         */
        System.out.println("Turning Light Off");
        
        remote.setCommand(lightOff);
        
        remote.pressButton();
        
        System.out.println("---------------------------");
        
        
        /*
         * Step 7:
         * Undo the previous command again.
         */
        System.out.println("Undo Last Command");
        
        remote.pressUndo();
    }
}
