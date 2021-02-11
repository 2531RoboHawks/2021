package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

public class DriveSubsystem extends SubsystemBase {
  Spark motor1 = new Spark(0);
  Spark motor2 = new Spark(1);
  Spark motor3 = new Spark(2);
  Spark motor4 = new Spark(3);

  public DriveSubsystem() {
    
  }

  public void motorControl(double frontLeft, double backLeft, double frontRight, double backRight) {
    motor3.set(frontLeft);
    motor4.set(backLeft);
    motor1.set(-frontRight);
    motor2.set(-backRight);
  }

  public void turn(double dir) {
    motorControl(dir, dir, -dir, -dir);
  }

  public void stop() {
    motorControl(0, 0, 0, 0);
  }

  @Override
  public void periodic() {

  }
}
