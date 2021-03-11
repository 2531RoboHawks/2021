// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ServoSubSystem extends SubsystemBase {
  Servo bottomServo = new Servo(0);
  Servo topServo = new Servo(1);

  /** Creates a new ServoSubSystem. */
  public ServoSubSystem() {
    servoControl(0.5, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void servoControl(double servo1, double servo2) {
    bottomServo.set(servo1);
    topServo.set(servo2);
  }

  public void setTopServo(double value) {
    topServo.set(value);
  }

  public void setBottomServo(double value) {
    bottomServo.set(value);
  }

  public double getTopServoAngle() {
    return topServo.get();
  }

  public double getBottomServoAngle() {
    return bottomServo.get();
  }

}
