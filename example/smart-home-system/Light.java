package commandpattern;

/*
 * Receiver Class
 * --------------
 * This class performs the actual business logic.
 * 
 * In the Command Pattern:
 * - The receiver knows HOW to perform the action.
 * - The receiver does NOT know who requested it.
 * 
 * This improves separation of concerns.
 */
public class Light {
    
    
    /*
     * Turns the light ON.
     * This represents a real operation performed by the receiver.
     */
    public void turnOn(){
        System.out.println("Light is On");
    }
    
    
    /*
     * Turns the light OFF.
     * Another operation supported by the receiver.
     */
    public void turnOff(){
        System.out.println("Light is Off");
    }
}
