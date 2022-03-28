// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PickupSubsystem;

public class PullupOverhang extends CommandBase {
  private final double m_speed;
  /** Creates a new ReleaseOverhang. */
  final PickupSubsystem m_pickupSubsystem;
  public PullupOverhang(PickupSubsystem pickupSubsystem,double speed) {
    m_speed = speed;
    m_pickupSubsystem = pickupSubsystem;
    addRequirements(pickupSubsystem);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pickupSubsystem.spinReleaseLine(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pickupSubsystem.stopReleaseLine();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
