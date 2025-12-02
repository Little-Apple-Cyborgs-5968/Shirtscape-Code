package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants.DriveConstants;

public class DriveBase extends SubsystemBase {

    private final SparkMax leftFront  = new SparkMax(DriveConstants.LEFT_FRONT_ID, MotorType.kBrushless);
    private final SparkMax leftBack   = new SparkMax(DriveConstants.LEFT_BACK_ID, MotorType.kBrushless);
    private final SparkMax rightFront = new SparkMax(DriveConstants.RIGHT_FRONT_ID, MotorType.kBrushless);
    private final SparkMax rightBack  = new SparkMax(DriveConstants.RIGHT_BACK_ID, MotorType.kBrushless);

    public DriveBase() {
        // invert one side so both sides move forward correctly
        rightFront.setInverted(true);
        rightBack.setInverted(true);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        // manally set all motors
        leftFront.set(leftSpeed);
        leftBack.set(leftSpeed);

        rightFront.set(rightSpeed);
        rightBack.set(rightSpeed);
    }
}
