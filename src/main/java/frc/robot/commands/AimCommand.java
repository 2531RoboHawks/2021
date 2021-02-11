package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ServoSubSystem;

public class AimCommand extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private final ServoSubSystem servoSubsystem;

  public AimCommand(DriveSubsystem subsystem, ServoSubSystem servoSubSystem) {
    this.driveSubsystem = subsystem;
    this.servoSubsystem = servoSubSystem;
    addRequirements(this.driveSubsystem);
    addRequirements(this.servoSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // double pressButton = RobotContainer.leftJoystick.getX();
    double MARGIN = 3.0;

    double tx = RobotContainer.limelight.getX();
    double ty = RobotContainer.limelight.getY();
    double bottom = servoSubsystem.getBottomServoAngle();
    double top = servoSubsystem.getTopServoAngle();
    if (tx > MARGIN) {
      bottom += 0.01;
    } else if (tx < -MARGIN) {
      bottom -= 0.01;
    }

    if (ty > MARGIN) {
      top -= 0.01;
    } else if (ty < -MARGIN) {
      top += 0.01;
    }

    if (top > 0.75) {
      top = 0.75;
    }

    servoSubsystem.servoControl(bottom, top);
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
