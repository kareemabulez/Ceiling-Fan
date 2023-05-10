import java.time.LocalDate;

public class Fan{
    int fanSpeed;
    boolean directionReversed;
    LocalDate todaysDate;
    LocalDate christmasDate;


    //Class for fan
    public Fan(){
    //initializations for fan speed and direction of fan
        fanSpeed = 0; //Fan speed initialized to be off
        directionReversed = false; //direction of fan initially as normal forward
        todaysDate = LocalDate.now();
        christmasDate = LocalDate.of(todaysDate.getYear(), 12, 25);
    }
    
    //method for pulling cord to increase speed
    //also checks the speed of the fan to turn it off after speed 3
    public void increaseFanSpeed(){
        //Checks first if today is not Christmas then
        //After speed 3 fan turns off else increments
        if((todaysDate.equals(christmasDate))){
            System.out.println("Fans are off today is Christmas!!");
        }
        else {
            fanSpeed = (fanSpeed == 3 ? fanSpeed = 0 : fanSpeed+1);
            System.out.println("\nSpeed is set at: " + fanSpeed + "\n"); //Checks fan speed
        }
    }
    
    //To reverse fan direction
    public void reverseFan(){
        if(fanSpeed != 0){ //as long as the fan is running
            directionReversed = !directionReversed; //reversing direction
        }
    }
    
    //To check the direction of the fan
    public void directionStatus(){
        System.out.println(fanSpeed == 0 ? "\nFan is currently off" 
        : ("\nDirection is: " + (directionReversed ? "backwards" : "forward") + "\n"));
    }
    
    
    public static void main(String[]args){
        Fan test = new Fan();
        //Testing fan's functionality
        test.increaseFanSpeed(); //pulling cord and speed is 1
        test.increaseFanSpeed(); //pulling cord and speed is 2
        test.increaseFanSpeed(); //pulling cord and speed is 3
        //Reversing Fan to backwards
        test.reverseFan(); //reversing fan direction
        test.directionStatus(); //checking the fan's direction changed after reversing
        test.increaseFanSpeed(); //pulling cord and speed is 0 after it reached 3 and its turned off
        test.increaseFanSpeed(); //pulling cord and speed is 1
        //Reversing Fan to forward
        test.reverseFan();
        test.directionStatus();
        
        //Checking again if the fan will shut off after 3
        test.increaseFanSpeed();
        test.increaseFanSpeed();
        test.increaseFanSpeed();
        test.directionStatus();
    }
}