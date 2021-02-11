package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Talon;

public class ShootSubsystem extends SubsystemBase {
  private Talon shooter = new Talon(10);

  public ShootSubsystem() {
    
  }

  public void shoot(double pow) {
    shooter.set(pow);
  }

  public void stop() {
    shoot(0);
  }
}
