package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveBase;
import frc.robot.Constants.DriveConstants;



public class DriveCommand extends Command {

    private static final double DRIVE_MULTIPLIER = 0.8;

    private final DriveBase drive;
    private final XboxController controller;

    public DriveCommand(DriveBase subsystem, XboxController xbox) {
        drive = subsystem;
        controller = xbox;
        addRequirements(drive);
        }

        @Override
        public void execute() {
        double leftX = -controller.getLeftX();
        double leftY = -controller.getLeftY();
        
        double rightX = -controller.getRightX();
        double rightY = -controller.getRightY();

        // deadband
        if (Math.abs(leftY) < DriveConstants.DRIVE_DEADBAND) leftY = 0;
        if (Math.abs(rightY) < DriveConstants.DRIVE_DEADBAND) rightX = 0;

        
        //drive.tankDrive(-1*(leftY-rightX), leftY-rightX);
        drive.tankDrive(leftY*DRIVE_MULTIPLIER, rightY*DRIVE_MULTIPLIER);
    }

    @Override
    public void end(boolean interrupted) {
        drive.tankDrive(0, 0);
    }
}
