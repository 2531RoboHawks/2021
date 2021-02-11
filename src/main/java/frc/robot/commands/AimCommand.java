package frc.robot.commands;

import javax.naming.spi.DirStateFactory;

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
    // if (!RobotContainer.limelight.hasValidTargets()) {
    //   driveSubsystem.stop();
    //   System.out.println("(Safety)");
    //   return;
    // }

    double tx = RobotContainer.limelight.getX();
    double ty = RobotContainer.limelight.getY();
    double ta = RobotContainer.limelight.getArea();
    System.out.println(String.format("tx: %f ty: %f ta: %f", tx, ty, ta));

    // FIXME: ta is often 0, unusable
    // ty -= 15.0;
    // ta -= 0.1;
    ta *= -1;

    // double bottom = servoSubsystem.getBottomServoAngle();
    // double top = servoSubsystem.getTopServoAngle();
    // if (tx > MARGIN) {
    //   bottom += 0.01;
    // } else if (tx < -MARGIN) {
    //   bottom -= 0.01;
    // }

    // if (ty > MARGIN) {
    //   top -= 0.01;
    // } else if (ty < -MARGIN) {
    //   top += 0.01;
    // }

    // if (top > 0.75) {
    //   top = 0.75;
    // }

    double turn = Math.pow(tx/30.0, 2) * Math.signum(tx);
    // double distance = Math.pow(ty/30.0, 2) * Math.signum(ty);
    double distance = Math.pow(ta, 2) * Math.signum(ta);
    // double distance = 0;
    // System.out.println(ta);
    // if (ta < 0.2) {
    //   distance = 0.5;
    // } else if (ta > 0.3) {
    //   distance = -0.5;
    // } else {
    //   distance = 0;
    // }

    // servoSubsystem.servoControl(bottom, top);
    // driveSubsystem.turn(Math.pow(tx/30.0, 2) * Math.signum(tx));
    driveSubsystem.motorControl(turn + distance, turn + distance, -turn + distance, -turn + distance);
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
