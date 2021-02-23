// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoShootCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutoShootCommandGroup. */
  public AutoShootCommandGroup() {
    addCommands(new InstantCommand(() -> {
      // RobotContainer.shootSubsystem.shoot(0.75); // 15
      RobotContainer.shootSubsystem.shoot(0.85); // 20
      // RobotContainer.intakeSubsystem.intake(1, 0);
    }));
    addCommands(new WaitCommand(10));
    // addCommands(new InstantCommand(() -> {
    //   RobotContainer.intakeSubsystem.intake(0, 0);
    // }));
    // addCommands(new WaitCommand(1));
    for (int i = 0; i < 3; i++) {
      addCommands(new InstantCommand(() -> {
        RobotContainer.intakeSubsystem.intake(-0.5, 0);
      }));
      addCommands(new WaitCommand(0.2));
      if (i != 2) {
        // addCommands(new InstantCommand(() -> {
        //   RobotContainer.intakeSubsystem.intake(1, 0);
        // }));
        // addCommands(new WaitCommand(2));
        addCommands(new InstantCommand(() -> {
          RobotContainer.intakeSubsystem.intake(0, 0);
        }));
        addCommands(new WaitCommand(2));
      }
    }
    addCommands(new InstantCommand(() -> {
      end(false);
    }));
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.shootSubsystem.stop();
    RobotContainer.intakeSubsystem.stopIntake();
  }
}
