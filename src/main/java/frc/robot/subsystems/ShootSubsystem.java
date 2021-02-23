package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class ShootSubsystem extends SubsystemBase {
  private TalonSRX shooter = new TalonSRX(10);

  public ShootSubsystem() {
    
  }

  public void shoot(double pow) {
    shooter.set(ControlMode.PercentOutput, pow);
  }

  public void stop() {
    shoot(0);
  }
}
