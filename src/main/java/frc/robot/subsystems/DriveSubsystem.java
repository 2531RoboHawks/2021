package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveSubsystem extends SubsystemBase {
  private TalonSRX leftMotor1 = new TalonSRX(5);
  private TalonSRX leftMotor2 = new TalonSRX(6);
  private TalonSRX rightMotor1 = new TalonSRX(7);
  private TalonSRX rightMotor2 = new TalonSRX(8);


  // pneumatics
  private Solenoid shifterHigh = new Solenoid(0);
  private Solenoid shifterLow = new Solenoid(1);

  public DriveSubsystem() {
      }

  public void tankDrive(double leftPower, double rightPower) {
    leftMotor1.set(ControlMode.PercentOutput, leftPower);
    leftMotor2.set(ControlMode.PercentOutput, leftPower);
    rightMotor1.set(ControlMode.PercentOutput, -rightPower);
    rightMotor2.set(ControlMode.PercentOutput, -rightPower);
  }

  public void arcadeDrive(double power, double steering) {
    double leftPower = (power + steering);
    double rightPower = (power - steering);
    tankDrive(leftPower, rightPower);

  }

  // double rotation = 0;
  // double threshold = 0.01;

  // public void calculateRotateValue(double targetAngle) {
  //   double error = targetAngle - RobotContainer.gyro.getAngle();
  //   System.out.println("Error = " + error + " Target = " + targetAngle);
  //   if (error > threshold) {
  //     rotation = error * 10;
  //     arcadeDrive(0.5, Math.signum(rotation));
  //   } else {
  //     rotation = 0;
  //     arcadeDrive(0, 0);
  //   }

  // }

  public boolean driveForDist(double distance) {
    System.out.println(RobotContainer.leftEncoder.getDistance() + " " + distance + " " + (RobotContainer.leftEncoder.getDistance() < distance));
    if (RobotContainer.leftEncoder.getDistance() < distance) {
      driveStraight(-0.5, -0.5);
      System.out.println("Running 1");
      return false;
    } else {
      RobotContainer.driveSubsystem.stop();
      System.out.println("Running 2");
      return true;
    }
  }

  double kP = 0.5;

  public void driveStraight(double left, double right) {
    System.out.println("Running 3");
    double error = RobotContainer.leftEncoder.getDistance() - RobotContainer.rightEncoder.getDistance();
    double leftVal = left + kP * error;
    double rightVal = right - kP * error;
    tankDrive(leftVal, rightVal);
  }

  public void shiftGear(boolean high) {
    shifterHigh.set(!high);
    shifterLow.set(high);
  }

  public boolean isHighGear() {
    return shifterHigh.get();
  }

  public void stop() {
    tankDrive(0, 0);
  }

  @Override
  public void periodic() {

  }
}
