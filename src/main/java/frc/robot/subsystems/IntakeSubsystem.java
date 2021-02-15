package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends SubsystemBase {
  Talon sweep = new Talon(9);
  Talon bottomIntake = new Talon(12);
  Talon topIntake = new Talon(13);

  public void intake(double pow0, double pow1) {
    bottomIntake.set(pow0);
    topIntake.set(pow1);
  }

  public void activateSweeper(boolean run) {
    if (run) {
      sweep.set(0.1);
    } else {
      sweep.set(0);
    }
  }

  public void stopIntake() {
    intake(0, 0);
  }
}
