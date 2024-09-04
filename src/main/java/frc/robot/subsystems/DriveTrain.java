// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  CANSparkMax leftMaster = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax rightMaster = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax rightSlave = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax leftSlave = new CANSparkMax(2, MotorType.kBrushless);


  RelativeEncoder encoderIzquierdo = leftMaster.getEncoder();
  RelativeEncoder encoderDerecho = rightMaster.getEncoder();
  
  public DriveTrain() {
    leftMaster.restoreFactoryDefaults();
    rightMaster.restoreFactoryDefaults();
    rightSlave.restoreFactoryDefaults();
    leftSlave.restoreFactoryDefaults();

    leftMaster.clearFaults();
    rightMaster.clearFaults();
    rightSlave.clearFaults();

    leftMaster.setInverted(false);
    rightMaster.setInverted(true);
    rightSlave.setInverted(true);

    rightMaster.setSmartCurrentLimit(40);
    leftMaster.setSmartCurrentLimit(40);
    rightSlave.setSmartCurrentLimit(40);
    leftSlave.setSmartCurrentLimit(40);

    rightMaster.setIdleMode(IdleMode.kBrake);
    leftMaster.setIdleMode(IdleMode.kBrake);
    rightSlave.setIdleMode(IdleMode.kBrake);
    leftSlave.setIdleMode(IdleMode.kBrake);


  }

  public void setArcadeDrive(double potenciaDerecha, double potenciaIzquierda){
    leftMaster.set(potenciaIzquierda);
    rightMaster.set(potenciaDerecha);
    leftSlave.set(potenciaIzquierda);
    rightSlave.set(potenciaDerecha);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Potencia derecha: ", rightMaster.get());
    SmartDashboard.putNumber("Potencia Izquierda", leftMaster.get());


    SmartDashboard.putNumber("Encoder derecho", encoderDerecho.getPosition());
    SmartDashboard.putNumber("Encoder izquierdo", encoderIzquierdo.getPosition());
    // This method will be called once per scheduler run
  }  
}