// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

public class AutoBalance extends PIDCommand {



  /** Creates a new AutoBalance. */
  public AutoBalance(DriveTrain drive,double p, double i, double d,double deadband) 
  {
    super(
      new PIDController(p, i, d),
      drive::getPitch,
      0.0,
      output -> {drive.driveRaw(0, -output);}
    );

    getController().enableContinuousInput(-180, 180);
    getController().setTolerance(deadband,4);
    

    // Use addRequirements() here to declare subsystem dependencies.
  }

 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}
