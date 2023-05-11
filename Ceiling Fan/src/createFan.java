import java.time.LocalDate;
import java.time.LocalTime;

public class Fan {
    int fanSpeed;
    final int OFF = 0;
    boolean directionReversed;
    LocalDate todaysDate;
    LocalDate christmasDate;
    
    //Class for fan
    public Fan() {
        //initializations for fan speed and direction of fan
        fanSpeed = OFF; //Fan speed initialized to be off
        directionReversed = false; //direction of fan initially as normal forward
        todaysDate = LocalDate.now();
        christmasDate = LocalDate.of(todaysDate.getYear(), 12, 25);
    }

    //method for pulling cord to increase speed
    //also checks the speed of the fan to turn it off after speed 3
    public void increaseFanSpeed() {
        // Check if today is Christmas eve
        if (todaysDate.equals(christmasDate.minusDays(1))) {
            // Keep the fan running till 11:59 PM of Christmas Eve then shuts off the fan when Christmas starts
            if (LocalTime.now().isBefore(LocalTime.of(23, 59))) {
                fanSpeed = (fanSpeed == 3 ? fanSpeed = OFF : fanSpeed + 1);
                System.out.println("\nSpeed is set at: " + fanSpeed + "\n"); //Checks fan speed
            } else {
                System.out.println("Fans are turning off as it's Christmas day now!");
                fanSpeed = OFF;
            }
        } 
        // Check if today is Christmas day
        else if (todaysDate.equals(christmasDate)) {
            System.out.println("Fans are off today is Christmas!!");
        } 
        // For other days
        else {
            fanSpeed = (fanSpeed == 3 ? fanSpeed = OFF : fanSpeed + 1);
            System.out.println("\nSpeed is set at: " + fanSpeed + "\n"); //Checks fan speed
        }
    }

    //To reverse fan direction
    public void reverseFan() {
        if (fanSpeed != OFF) { //as long as the fan is running
            directionReversed = !directionReversed; //reversing direction
        }
    }

    //To check the direction of the fan
    public void directionStatus() {
        System.out.println(fanSpeed == OFF ? "\nFan is currently off"
                : ("\nDirection is: " + (directionReversed ? "backwards" : "forward") + "\n"));
    }
}
