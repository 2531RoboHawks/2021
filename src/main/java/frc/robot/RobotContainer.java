/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AimCommand;
import frc.robot.commands.AutoNavCommandGroup;
import frc.robot.commands.AutoShootCommandGroup;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LLServoCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ServoSubSystem;
import frc.robot.subsystems.ShootSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static ServoSubSystem servoSubsystem = new ServoSubSystem();
  public static ShootSubsystem shootSubsystem = new ShootSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  public static Joystick leftJoystick = new Joystick(1);
  public static Joystick rightJoystick = new Joystick(0);

  public static Limelight limelight = new Limelight();

  public static Gyro gyro = new Gyro();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Attach a command to a button here. 
    
    //TODO: No idea how or why this works right now. Figure out later
    JoystickButton aimButton = new JoystickButton(leftJoystick, 8);
    JoystickButton revButton = new JoystickButton(leftJoystick, 3);

    aimButton.toggleWhenPressed(new AimCommand(driveSubsystem, servoSubsystem))
    .whenInactive(new LLServoCommand(servoSubsystem), true);
    
    revButton.whenHeld(new ShootCommand());
    
    intakeSubsystem.setDefaultCommand(new IntakeCommand(intakeSubsystem));
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem));
  }

  public Command getAutonomousCommand() {
    return new AutoNavCommandGroup();
  }
}
