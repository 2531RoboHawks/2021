package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

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
