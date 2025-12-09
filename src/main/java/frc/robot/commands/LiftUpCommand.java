package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lift;

public class LiftUpCommand extends Command {

    private final Lift lift;

    public LiftUpCommand(Lift subsystem) {
        lift = subsystem;
        addRequirements(lift);
    }

    @Override
    public void execute() {
        lift.move(0.5);  // up
    }

    @Override
    public void end(boolean interrupted) {
        lift.move(0);    // stop
    }
}