package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveBase;
import frc.robot.Constants.OIConstants;

public class RobotContainer {

    private final DriveBase driveBase = new DriveBase();
    private final XboxController driverController = new XboxController(OIConstants.DRIVER_CONTROLLER_PORT);

    public RobotContainer() {
        driveBase.setDefaultCommand(
            new DriveCommand(driveBase, driverController)
        );
    }

    public Command getAutonomousCommand() {
        return null; // no auto for now
    }
}
