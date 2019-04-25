package org.firebears.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.firebears.commands.DriveCommand;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Chassis extends Subsystem {

    private CANSparkMax rearRight;
    private CANSparkMax frontRight;
    public SpeedControllerGroup rightMotors;
    private CANSparkMax frontLeft;
    private CANSparkMax rearLeft;
    public SpeedControllerGroup leftMotors;
    private DifferentialDrive robotDrive;

    public Chassis() {

        int chassisRearRightCanID = 2;
        rearRight = new CANSparkMax(chassisRearRightCanID, MotorType.kBrushless);
        rearRight.setInverted(false);

        int chassisFrontRightCanID = 3;
        frontRight = new CANSparkMax(chassisFrontRightCanID, MotorType.kBrushless);
        frontRight.setInverted(false);

        rightMotors = new SpeedControllerGroup(rearRight, frontRight);
        addChild("RightMotors", rightMotors);

        int chassisFrontLeftCanID = 4;
        frontLeft = new CANSparkMax(chassisFrontLeftCanID, MotorType.kBrushless);
        frontLeft.setInverted(false);

        int chassisRearLeftCanID = 5;
        rearLeft = new CANSparkMax(chassisRearLeftCanID, MotorType.kBrushless);
        rearLeft.setInverted(false);

        leftMotors = new SpeedControllerGroup(frontLeft, rearLeft);
        addChild("LeftMotors", leftMotors);

        robotDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("RobotDrive", robotDrive);
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setMaxOutput(1.0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void drive(double speed, double rotation) {
        robotDrive.arcadeDrive(speed, rotation);
    }
}
