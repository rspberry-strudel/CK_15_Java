package krunch15;


import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
 
    public static CANJaguar leftFrontMotor, rightFrontMotor, leftRearMotor,
            rightRearMotor;
    public static CANJaguar collectorMotor, upperConveyerMotor, lowerConveyerMotor;
    public static DigitalInput lowerIntakeSwitch, upperIntakeSwitch;
    public static RobotDrive robotDrive;
    public static Compressor compressor;
    public static DoubleSolenoid sonicShifter, bridgeTipperPistons;
    
    public static void init(){
        loadComponents(true); // Used to init CSVs and all components
    }
    
    public static void reload(){
        loadComponents(false); // Reload CSV values without reiniting CSVReaders.
    }
    
    private static void loadComponents(boolean initCSVs)
    {
        // Init Drive Wheels
        try {
            leftFrontMotor = new CANJaguar(5);
            leftRearMotor = new CANJaguar(4);
            rightFrontMotor = new CANJaguar(2);
            rightRearMotor = new CANJaguar(3);
            
            collectorMotor = new CANJaguar(9);
            lowerConveyerMotor = new CANJaguar(7);
            upperConveyerMotor = new CANJaguar(6);
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        // Sensors for ball riding up intake
        lowerIntakeSwitch = new DigitalInput(13);
        upperIntakeSwitch = new DigitalInput(14);
        
        // Init Compressor (pressureSwitchChannel,compressorRelayChannel)
        compressor = new Compressor(1,8);

        // Init Solenoids
        sonicShifter = new DoubleSolenoid(8,7);     // (forward ch., reverse ch.)
        bridgeTipperPistons = new DoubleSolenoid(4, 3);
    }
}
