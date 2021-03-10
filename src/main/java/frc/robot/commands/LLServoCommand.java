// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ServoSubSystem;

public class LLServoCommand extends CommandBase {
  private final ServoSubSystem servoSubsystem;

  JoystickButton limeLeft = new JoystickButton(RobotContainer.rightJoystick, 4);
  JoystickButton limeRight = new JoystickButton(RobotContainer.rightJoystick, 5);
  JoystickButton limeUp = new JoystickButton(RobotContainer.rightJoystick, 3);
  JoystickButton limeDown = new JoystickButton(RobotContainer.rightJoystick, 2);
  double angleUD = 0;
  double angleLR = 0;

  /** Creates a new LLServoCommand. */
  public LLServoCommand(ServoSubSystem servoSubsystem) {
    this.servoSubsystem = servoSubsystem;
    addRequirements(this.servoSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(limeLeft.get()){
      angleLR += 0.1;
    } else if(limeRight.get()) {
      angleLR -= 0.1;
    } else if(limeUp.get()) {
      angleUD += 0.1;
    } else if(limeDown.get()) {
      angleUD -= 0.1;
    }

    servoSubsystem.setTopServo(angleUD);
    servoSubsystem.setBottomServo(angleLR);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
