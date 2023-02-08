// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

//import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private WPI_VictorSPX frontLeftMotor;
  private WPI_VictorSPX backLeftMotor;
  private WPI_VictorSPX frontRightMotor;
  private WPI_VictorSPX backRightMotor;

  private MotorControllerGroup left;
  private MotorControllerGroup right;

  private DifferentialDrive drive;

  public DriveTrain() {
    frontLeftMotor = new WPI_VictorSPX(Constants.frontLeftMotor);
    backLeftMotor = new WPI_VictorSPX(Constants.backLeftMotor);
    frontRightMotor = new WPI_VictorSPX(Constants.frontRightMotor);
    backRightMotor = new WPI_VictorSPX(Constants.backRightMotor);

    left = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    right = new MotorControllerGroup(frontRightMotor, backRightMotor);

    drive = new DifferentialDrive(left, right);
  }

  public void drive(double x, double z){
    drive.arcadeDrive(z, x);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
