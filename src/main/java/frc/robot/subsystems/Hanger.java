// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hanger extends SubsystemBase {

  public WPI_VictorSPX leftMotor;
  public WPI_VictorSPX rightMotor;

  /** Creates a new Hanger. */
  public Hanger() {
    leftMotor = new WPI_VictorSPX(Constants.liftMotorLeft);
    rightMotor = new WPI_VictorSPX(Constants.liftMotorRight);
  }

  public void lift(double speed){
    leftMotor.set(speed);
    rightMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
