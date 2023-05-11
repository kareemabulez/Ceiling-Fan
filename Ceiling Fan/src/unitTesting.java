import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class FanTest {
    private Fan fan;
    
    @Before
    public void setUp() {
        fan = new Fan();
    }
    
    @Test
    //This to test the speed of the fan and the functionality
    public void testIncreaseFanSpeed() {
        fan.increaseFanSpeed(); // speed should be 1
        fan.increaseFanSpeed(); // speed should be 2
        fan.increaseFanSpeed(); // speed should be 3
        fan.increaseFanSpeed(); // speed should be OFF
        fan.increaseFanSpeed(); // speed should be 1
        fan.increaseFanSpeed(); // speed should be 2
    }
    
    @Test
    //This to test the reversing functionality of the fan
    public void testReverseFan() {
        fan.reverseFan(); // fan is off, direction should not be reversed
        fan.increaseFanSpeed(); // fan speed is 1, direction should not be reversed
        fan.reverseFan(); // fan direction should be reversed
        fan.reverseFan(); // fan direction should be back to normal
    }
    
    @Test
    //This to test if the direction of the fan whether it stays the same or not during the changing of the speed
    public void testDirectionStatus() {
        fan.directionStatus(); // fan is off, direction should not be displayed
        fan.increaseFanSpeed(); // fan speed is 1, direction should not be displayed
        fan.directionStatus(); // fan direction should not be reversed, should display "forward"
        fan.reverseFan(); // fan direction should be reversed
        fan.directionStatus(); // fan direction should be reversed, should display "backwards"
    }
    
    @Test
    //To test if the fan will work on Christmas Eve
    public void testIncreaseFanSpeedOnChristmasEve() {
        // Set up the fan's date to be Christmas Eve
        fan.todaysDate = LocalDate.of(fan.todaysDate.getYear(), 12, 24);
        
        // Increase the fan speed a few times, the fan should not turn off yet
        fan.increaseFanSpeed(); // speed should be 1
        fan.increaseFanSpeed(); // speed should be 2
        fan.increaseFanSpeed(); // speed should be 3
        fan.increaseFanSpeed(); // speed should be OFF
        fan.increaseFanSpeed(); // speed should be 1
        fan.increaseFanSpeed(); // speed should be 2
        
        // Set the current time to be after 11:59 PM
        LocalTime.now().withHour(23).withMinute(59).withSecond(0);
        
        // Increase the fan speed, the fan should turn off
        fan.increaseFanSpeed(); // speed should be OFF
    }
    
    @Test
    //To test if the fan will work on Christmas day or not
    public void testIncreaseFanSpeedOnChristmasDay() {
        // Set up the fan's date to be Christmas Day
        fan.todaysDate = LocalDate.of(fan.todaysDate.getYear(), 12, 25);
        
        // Increase the fan speed, the fan should not turn on
        fan.increaseFanSpeed(); // fan should not turn on
    }
}
