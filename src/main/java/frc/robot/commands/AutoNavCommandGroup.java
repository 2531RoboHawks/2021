// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class AutoNavCommandGroup extends SequentialCommandGroup {

  public AutoNavCommandGroup() {
    turnToAngle(90);
  }

  public void loopAround() {
    addCommands(new InstantCommand(() -> {
      RobotContainer.driveSubsystem.tankDrive(0.5, 0.9);
    }), 
    new WaitCommand(3),
    new InstantCommand(() -> {end(false);})
    );

    addCommands(new InstantCommand(() -> {
      end(false);
    }));
  }

  public void driveForTime(double speed, double time) {
    addCommands(new InstantCommand(() -> {
      RobotContainer.driveSubsystem.tankDrive(speed, speed);
    }), 
    
    new WaitCommand(time),

    new InstantCommand(() -> {
      end(false);
    }));
  }

  public void turnToAngle(double angle) {
    addCommands(new InstantCommand(() -> {
      RobotContainer.driveSubsystem.turnToAngle(angle);
    }));
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.stop();
  }
}
