package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private boolean lastgear;

  public DriveCommand(DriveSubsystem subsystem) {
    this.driveSubsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    if (RobotContainer.rightJoystick.getRawButton(1)) {
      driveSubsystem.shiftGear(true);
      if (!lastgear) {
        System.out.println("high gear");
        lastgear = true;
      }
    } else {
      driveSubsystem.shiftGear(false);
      if (lastgear) {
        System.out.println("low gear");
        lastgear = false;
      }
    }

    double leftX = RobotContainer.leftJoystick.getRawAxis(1);
    double leftY = RobotContainer.rightJoystick.getRawAxis(1);

    driveSubsystem.tankDrive(leftX, leftY);


    
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
