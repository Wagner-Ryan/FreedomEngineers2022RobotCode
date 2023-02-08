// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DefaultDrive extends CommandBase {

  private final DriveTrain driveTrain;
  private Joystick driver;

  /** Creates a new DefaultDrive. */
  public DefaultDrive(DriveTrain driveTrain, Joystick driver) {
    this.driveTrain = driveTrain;
    this.driver = driver;
    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = driver.getRawAxis(Constants.forwardButton);
    double xReverse = driver.getRawAxis(Constants.backButton);
    double z = driver.getRawAxis(Constants.zRotation);
    driveTrain.drive(x - xReverse, z);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
