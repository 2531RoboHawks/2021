// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TurnToEncValCommand extends CommandBase {
  private boolean finished = false;

  private double endAngle;
  private double time;

  private double insidePath;
  private double outsidePath;

  private double width = 1.9;
  private double radius;

  /** Creates a new TurnToEncValCommand. */
  public TurnToEncValCommand(double radius, double endAngle, double time) {
    this.radius = radius;     // 1.5
    this.endAngle = endAngle; // 90
    this.time = time;         // 5 seconds

    

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    insidePath = 2*Math.PI*radius*(endAngle/360.0);         //2.4
    outsidePath = 2*Math.PI*(radius+width)*(endAngle/360.0);//5.3
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = insidePath / time;
    double rightSpeed = outsidePath / time;

    double proportionalLeft = (leftSpeed*0.5)/rightSpeed;
    double proportionalRight = 0.5;

    double leftError = insidePath - RobotContainer.leftEncoder.getDistance();
    double rightError = outsidePath - RobotContainer.rightEncoder.getDistance();
    //  left     X
    //  ----- = ---
    //  right    1
    //
    // left*1=right*X
    // left*1/right = x

    RobotContainer.driveSubsystem.tankDrive(proportionalLeft, proportionalRight);

    if(leftError < 0.1 && rightError < 0.1) {
      end(false);
      finished = true;
    }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
