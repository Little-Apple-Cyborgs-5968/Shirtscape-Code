package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveBase;
import frc.robot.Constants.DriveConstants;

public class DriveCommand extends Command {

    private final DriveBase drive;
    private final XboxController controller;

    public DriveCommand(DriveBase subsystem, XboxController xbox) {
        drive = subsystem;
        controller = xbox;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        double left = -controller.getLeftY();
        double right = -controller.getRightY();

        // deadband
        if (Math.abs(left) < DriveConstants.DRIVE_DEADBAND) left = 0;
        if (Math.abs(right) < DriveConstants.DRIVE_DEADBAND) right = 0;

        drive.tankDrive(left, right);
    }

    @Override
    public void end(boolean interrupted) {
        drive.tankDrive(0, 0);
    }
}
