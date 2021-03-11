package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends SubsystemBase {
  TalonSRX sweep = new TalonSRX(9);
  TalonSRX bottomIntake = new TalonSRX(12);
  TalonSRX topIntake = new TalonSRX(13);

  public void intake(double pow0, double pow1) {
    bottomIntake.set(ControlMode.PercentOutput, pow0);
    topIntake.set(ControlMode.PercentOutput, pow1);
  }

  public void activateSweeper(boolean run) {
    if (run) {
      sweep.set(ControlMode.PercentOutput, 0.1);
    } else {
      sweep.set(ControlMode.PercentOutput, 0);
    }
  }

  public void stopIntake() {
    intake(0, 0);
  }
}
