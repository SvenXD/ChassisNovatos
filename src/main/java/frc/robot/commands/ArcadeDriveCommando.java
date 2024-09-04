// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDriveCommando extends Command {
  /** Creates a new ArcadeDriveCommando. */
  DriveTrain drivetrain;
  Joystick control;

  public ArcadeDriveCommando(DriveTrain drivetrain, Joystick control) {
    this.drivetrain = drivetrain;
    this.control = control;

    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double potenciaDerecha = (control.getRawAxis(1))  + (control.getRawAxis(4) * 0.5);
    double potenciaIzquierda = (control.getRawAxis(1)) - (control.getRawAxis(4)*0.5);

    drivetrain.setArcadeDrive(potenciaIzquierda, potenciaDerecha);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}