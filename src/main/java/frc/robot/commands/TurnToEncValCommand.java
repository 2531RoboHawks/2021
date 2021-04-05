// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TurnToEncValCommand extends CommandBase {
  private double endAngle;
  private double time;

  private double insidePath;
  private double outsidePath;

  private double width = 1.9;
  private double radius;

  private double leftError = 0;
  private double rightError = 0;

  private double kp = 0.2;

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
    insidePath = (2*Math.PI*radius)*(endAngle/360.0);         //2.4
    outsidePath = (2*Math.PI)*(radius+width)*(endAngle/360.0);//5.3
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = insidePath / time;
    double rightSpeed = outsidePath / time;

    double proportionalLeft = (leftSpeed*0.5)/rightSpeed;
    double proportionalRight = 0.5;

    leftError =  (RobotContainer.leftEncoder.getDistance()/12.0) - insidePath;
    rightError = (RobotContainer.rightEncoder.getDistance()/12.0) - outsidePath;
    
    double leftVal = leftSpeed + kp * leftError;
    double rightVal = rightSpeed + kp * rightError;

    RobotContainer.driveSubsystem.tankDrive(leftVal, rightVal);
    System.out.println("LE " + leftError + ", RE " + rightError + ", LP " + insidePath + ", RP " + outsidePath);

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(leftError) < 1 && Math.abs(rightError) < 1) {
      RobotContainer.driveSubsystem.stop();
      return true;
    }
    return false;
  }
}
