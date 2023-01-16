// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
//import XboxController class
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();
//makes an object of the Forward_14_Inches class
  private final Forward_14_Inches m_forward_14_inches = new m_forward_14_inches(m_romiDrivetrain);
//makes an object of the Forward class
  private final Forward m_forward = new Forward(m_romiDrivetrain, 15);
  //makes an object of the XboxController class
  private static final XboxController m_XboxController = new XboxController(0);
  //makes an object of the DriveWithController class
  private final DriveWithController m_DriveWithController = new DriveWithController(m_romiDrivetrain);
  //makes an object of teh PIDRomi class
  private final PIDRomi m_PIDRomi =  new PIDRomi(m_romiDrivetrain); 
  //makes an object of the PIDInches class 
  // private final PIDInches m_PIDInches = new PIDInches(m_RomiDrivetrain, 10);
  //Make an object of the Turn90Degrees.java
  private final Turn90Degrees m_Turn90Degrees = new Turn90Degrees(m_romiDriveTrain, 90);
  //turn -90 degrres
   private final Turn90Degrees m_TurnNegative90Degrees = new Turn90Degrees(m_romiDriveTrain, -90);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return WaitCommand(0.2).andThen(m_PIDInches).alongWith(m_Turn90Degrees).alongWith(m_PIDInches).alongWith(m_Turn90Degrees).alongWith(m_PIDInches).alongWith(m_Turn90Degrees).alongWith(m_PIDInches);
    return WaitCommand(0.2).andThen(new PIDInches(m_romiDrivetrain, 30.5)).andThen(m_Turn90Degrees).andThen(new PIDInches(m_romiDrivetrain, 48)).andThen(m_TurnNegative90Degrees).andThen(new PIDInches(m_romiDrivetrain, 24)).andThen(m_Turn90Degrees).andThen(new PIDInches(m_romiDrivetrain, 50));
  }
}
