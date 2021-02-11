package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  private final DriveSubsystem subsystem;

  public DriveCommand(DriveSubsystem subsystem) {
    this.subsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    // double leftX = RobotContainer.leftJoystick.getX();
    // double leftY = RobotContainer.leftJoystick.getY();
    // double rightX = RobotContainer.rightJoystick.getX();
    // double rightY = RobotContainer.rightJoystick.getY();

    // subsystem.motorControl(
    //   leftY - leftX - rightX + rightY,
    //   leftY + leftX - rightX + rightY,
    //   -leftY - leftX - rightX + rightY,  
    //   -leftY + leftX - rightX + rightY
    // );
  }

  @Override
  public void end(boolean interrupted) {
    subsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
