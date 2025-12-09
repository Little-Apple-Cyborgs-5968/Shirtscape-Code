package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LiftUpCommand;
import frc.robot.commands.LiftDownCommand;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Lift;
import frc.robot.Constants.OIConstants;

public class RobotContainer {

    private final DriveBase driveBase = new DriveBase();
    private final Lift lift = new Lift();
    private final XboxController driverController = new XboxController(OIConstants.DRIVER_CONTROLLER_PORT);
    

    public RobotContainer() {
        driveBase.setDefaultCommand(
            new DriveCommand(driveBase, driverController)
        );
        new JoystickButton(driverController, XboxController.Button.kA.value).whileTrue(new LiftUpCommand(lift));
        new JoystickButton(driverController, XboxController.Button.kB.value).whileTrue(new LiftDownCommand(lift));

    }

    public Command getAutonomousCommand() {
        return null; // no auto for now
    }
}
