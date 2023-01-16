// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Forward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
  private final double distance;
  //makes an object of PIDController class
  PIDController m_PIDController = new PIDController(0.1, 0, 0);

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Forward(RomiDrivetrain db, double inches) {
    m_db = db;
    //checks to see if inches is positive or negative. If it is posivitve, we set distance equal to icnhes. If not, we set distance to 0.
    if (inches > 0) {
      distance = inches;
    }
    else {
      distance = 0;
    }
   
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(db);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //reset encoders
    m_db.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //move robot forward
    m_db.arcadeDrive(0.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //stops robot
    m_db.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //if our distance is move than or equal to the getAVerageDistanceInch, we will stop the robot
    return (m_db.getAverageDistanceInch() >= distance);
  }
}
