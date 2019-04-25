package org.firebears;

import org.firebears.recording.PlayRecordingCommand;
import org.firebears.recording.RecordingFactory;
import org.firebears.recording.StartRecordingCommand;
import org.firebears.recording.StopRecordingCommand;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
 
    public XboxController xboxController;
    private JoystickButton buttonB; // b 2
    private JoystickButton buttonA; // a 1
    private JoystickButton buttonY; // y 4 free button
    private JoystickButton buttonX; // x 3 
    private JoystickButton rightBumper; // right bumper 6
    private JoystickButton leftBumper; // left bumper 5
    private JoystickButton buttonStart; //
    public final RecordingFactory recordingFactory;
   
    public OI() {
        recordingFactory = new RecordingFactory();
        recordingFactory.add(Robot.chassis.leftMotors, "leftMotors");
        recordingFactory.add(Robot.chassis.rightMotors, "rightMotors");

        xboxController = new XboxController(0);
        buttonX = new JoystickButton(xboxController, 3);
        buttonA = new JoystickButton(xboxController, 1);
        buttonY = new JoystickButton(xboxController, 4);
        buttonB = new JoystickButton(xboxController, 2);
        buttonStart = new JoystickButton(xboxController, 8);

        buttonX.whenPressed(new StartRecordingCommand(recordingFactory));
        buttonB.whenPressed(new StopRecordingCommand(recordingFactory));
        buttonStart.whenPressed(new PlayRecordingCommand(recordingFactory));
    }

}
