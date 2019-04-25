package org.firebears.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.firebears.Robot;

public class DriveCommand extends Command {

    public DriveCommand() {
        requires(Robot.chassis);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double speed = -1 * Robot.oi.xboxController.getRawAxis(1);
        double rotation = Robot.oi.xboxController.getRawAxis(4) * 0.6;
        Robot.chassis.drive(speed,rotation);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

}
