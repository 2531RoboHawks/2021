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
    loopAround();
  }

  public void loopAround() {
    addCommands(new InstantCommand(() -> {
      RobotContainer.driveSubsystem.tankDrive(0.25, 0.5);
    }), 
    new WaitCommand(1)
    );
    
  }
}
