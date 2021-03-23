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
    driveForTime(-0.4, 5);
    loopAround(-0.9, -0.4, 4.2);
    rotateToAngle(0);
    driveForTime(-0.4, 3);
    loopAround(-0.4, -0.9, 4.2);
  }

  public void loopAround(double lSpeed, double rSpeed, double time) {
    addCommands(new InstantCommand(() -> {
      RobotContainer.driveSubsystem.tankDrive(lSpeed, rSpeed); 
      
    }), 
    new WaitCommand(time),
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

  public void rotateToAngle(double angle) {
    addCommands(new RotateAngleCommand(angle));
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.stop();
  }
}
