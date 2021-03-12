package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ServoSubSystem;

public class AimCommand extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private final ServoSubSystem servoSubsystem;

  double bottom = 0;
  double top = 0;

  double tx = RobotContainer.limelight.getX();
  double ty = RobotContainer.limelight.getY();
  double ta = RobotContainer.limelight.getArea();
  double tv = RobotContainer.limelight.hasValidTargets();

  public AimCommand(DriveSubsystem subsystem, ServoSubSystem servoSubSystem) {
    this.driveSubsystem = subsystem;
    this.servoSubsystem = servoSubSystem;
    addRequirements(this.driveSubsystem);
    addRequirements(this.servoSubsystem);
  }

  @Override
  public void initialize() {
    bottom = servoSubsystem.getBottomServoAngle();
    top = servoSubsystem.getTopServoAngle();
  }

  @Override
  public void execute() {
    //FIXME: Figure out why this doesn't work. Probably Useful for something
    // if (!RobotContainer.limelight.hasValidTargets()) {
    //   driveSubsystem.stop();
    //   System.out.println("(Safety)");
    //   return;
    // }

    System.out.println(String.format("tx: %f ty: %f ta: %f tv: %f", tx, ty, ta, tv));

    double MARGIN = 0.1;
    if (tx > MARGIN && bottom > 0.0) {
      bottom -= 0.01;
    } else if (tx < -MARGIN && bottom < 1.0) {
      bottom += 0.01;
    }

    if (ty > MARGIN && top > 0.0) {
      top -= 0.01;
    } else if (ty < -MARGIN && top < 1.0) {
      top += 0.01;
    }
    
    // double distance = Math.pow(ty/30.0, 2) * Math.signum(ty);
    // double distance = Math.pow(ta, 2) * Math.signum(ta);
    // double distance = 0;
    // System.out.println(ta);
    // if (ta < 0.2) {
    //   distance = 0.5;
    // } else if (ta > 0.3) {
    //   distance = -0.5;
    // } else {
    //   distance = 0;
    // }

    servoSubsystem.setTopServo(top);
    servoSubsystem.setBottomServo(bottom);
    //driveSubsystem.tankDrive(turn + distance, -turn + distance);
  }

  public void aimTarget() {
    if(Math.abs(tx) > 0.1) {
      double turn = Math.pow(tx/30.0, 2) * Math.signum(tx);
      driveSubsystem.tankDrive(turn, -turn);
    }
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
