// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hanger;

public class AutoHang extends CommandBase {

  private Hanger hanger;
  private double speed, time;
  private Timer timer;
  /** Creates a new AutoHang. */
  public AutoHang(Hanger hanger, double speed, double time) {
    this.hanger = hanger;
    this.speed = speed;
    this.time = time;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hanger);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hanger.lift(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hanger.lift(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() > time){
      return true;
    }
    else return false;
  }
}
