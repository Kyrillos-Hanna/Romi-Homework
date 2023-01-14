// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Forward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
  private final double distance;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Forward(RomiDrivetrain forward, double inches) {
    m_Forward = forward;
    if (inches > 0) {
      distance = inches;
    }
    else {
      distance = 0;
    }
   
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(forward);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_db.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Forward.arcadeDrive(0.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Forward.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_Forward.getAverageDistanceInch() >= distance);
  }
}
