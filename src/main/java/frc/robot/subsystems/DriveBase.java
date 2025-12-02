package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.DriveConstants;

public class DriveBase extends SubsystemBase {

    private final CANSparkMax leftFront = new CANSparkMax(DriveConstants.LEFT_FRONT_ID, MotorType.kBrushed);
    private final CANSparkMax leftBack = new CANSparkMax(DriveConstants.LEFT_BACK_ID, MotorType.kBrushed);
    private final CANSparkMax rightFront = new CANSparkMax(DriveConstants.RIGHT_FRONT_ID, MotorType.kBrushed);
    private final CANSparkMax rightBack = new CANSparkMax(DriveConstants.RIGHT_BACK_ID, MotorType.kBrushed);

    public DriveBase() {
        leftBack.follow(leftFront);
        rightBack.follow(rightFront);

        rightFront.setInverted(true);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        leftFront.set(leftSpeed);
        rightFront.set(rightSpeed);
    }
}
