package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OtherMotorConstants;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Lift extends SubsystemBase {

    private final SparkMax liftMotor = new SparkMax(OtherMotorConstants.LIFT, MotorType.kBrushed);

    public Lift() {
        
    }

    public void move(double speed) {
        liftMotor.set(speed);
    }
}