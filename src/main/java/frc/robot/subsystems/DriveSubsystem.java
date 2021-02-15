package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;

public class DriveSubsystem extends SubsystemBase {
  //TODO: Remove when put on robot EDNKHS
  Spark motor1 = new Spark(0);
  Spark motor2 = new Spark(1);
  Spark motor3 = new Spark(2);
  Spark motor4 = new Spark(3);

  private Talon leftMotor1 = new Talon(5);
  private Talon leftMotor2 = new Talon(6);
  private Talon rightMotor1 = new Talon(7);
  private Talon rightMotor2 = new Talon(8);

  // pneumatics
  private Solenoid shifterHigh = new Solenoid(0);
  private Solenoid shifterLow = new Solenoid(1);

  public DriveSubsystem() {
    
  }

  //TODO: Remove when put on robot EDNKHS
  public void motorControl(double frontLeft, double backLeft, double frontRight, double backRight) {
    motor3.set(frontLeft);
    motor4.set(backLeft);
    motor1.set(-frontRight);
    motor2.set(-backRight);
  }

  //TODO: Remove when put on robot EDNKHS
  public void turn(double dir) {
    motorControl(dir, dir, -dir, -dir);
  }

  public void tankDrive(double leftPower, double rightPower) {
    leftMotor1.set(leftPower);
    leftMotor2.set(leftPower);
    rightMotor1.set(-rightPower);
    rightMotor2.set(-rightPower);
  }

  public void arcadeDrive(double power, double steering) {
    double leftPower = (power + steering);
    double rightPower = (power - steering);
    tankDrive(leftPower, rightPower);
  }

  public void shiftGear(boolean high) {
    shifterHigh.set(!high);
    shifterLow.set(high);
  }

  public boolean isHighGear() {
    return shifterHigh.get();
  }

  public void stop() {
    //TODO: Remove when put on robot EDNKHS
    motorControl(0, 0, 0, 0);

    tankDrive(0, 0);
  }

  //Use this for something? Could be useful
  @Override
  public void periodic() {

  }
}
