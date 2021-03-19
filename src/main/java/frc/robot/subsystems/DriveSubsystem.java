package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

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

  public boolean turnToAngle(double angleInDegrees) {
    if(Math.abs(RobotContainer.gyro.getAngle() - angleInDegrees) > 1) {
      double turn = Math.min(0.75, (Math.abs(RobotContainer.gyro.getAngle())/25)) * Math.signum(RobotContainer.gyro.getAngle());
      tankDrive(-turn, turn);
      return false;
    } else {
      stop();
      return true;
    }
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
