// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveDistanceCommand extends CommandBase {
  double distance = 0;
  boolean finished = false;
  /** Creates a new DriveDistanceCommand. */
  public DriveDistanceCommand(double distance) {
    this.distance = distance;
    addRequirements(RobotContainer.driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean done = RobotContainer.driveSubsystem.driveForDist(distance);
    if(done) {
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.stop();
    finished = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
