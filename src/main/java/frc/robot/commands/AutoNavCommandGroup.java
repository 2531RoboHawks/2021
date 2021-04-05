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
    // addCommands(new DriveDistanceCommand(182));
    addCommands(new TurnToEncValCommand(1.5, 180.0, 10));

    // driveForTime(-0.4, 5);
    
    // driveForTime(-0.4, 3);
    // loopAround(-0.4, -0.9, 4.2);
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

  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveSubsystem.stop();
  }
}
