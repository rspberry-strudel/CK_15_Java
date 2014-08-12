
package krunch15;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public Joystick driverJoystick, shooterGamepad;
    public JoystickButton shiftButton, collectButton, reverseCollectorButton,
            invertBridgeTipperButton;
    
    public OI()
    {
        // Init Joystick and Gamepad
        driverJoystick = new Joystick(1);
        shooterGamepad = new Joystick(2);
        
        // Init joystick buttons
        shiftButton = new JoystickButton(driverJoystick, 8);
        
        collectButton = new JoystickButton(shooterGamepad, 8);
        reverseCollectorButton = new JoystickButton(shooterGamepad, 3);
        invertBridgeTipperButton = new JoystickButton(shooterGamepad, 5);
    }

    public Joystick getDriverJoystick() {
        return driverJoystick;
    }

    public Joystick getShooterGamepad() {
        return shooterGamepad;
    }
    
}

