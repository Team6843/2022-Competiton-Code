// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

//place holder for pnuematics system 
//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;



import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PickupSubsystem extends SubsystemBase {
  /** Creates a new LaucherSystem. */
  private final MotorController m_pickupMotor = new WPI_VictorSPX(0);
  private final MotorController m_overhangMotor = new WPI_TalonSRX(0);

  //private Compressor compressor = new Compressor(0, null); // Instantiating the compressor establishes the entire pneumatic system
  private Solenoid dropOverhang = new Solenoid(null, 0);


  public PickupSubsystem() {
    dropOverhang.set(false);
    
    //will I need these? 
    //pullMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0); // Tell the motor controllers that there are encoders connected to them
    //pullMotor.setSensorPhase(true); // Inverts the phase of the Encoder
    //pullMotor.setNeutralMode(NeutralMode.Brake); // Tells the motor to stop spinning when it is stopped, instead of coastinng to a stop
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //spin front motor
  public void spinPickup(double speed){
    m_pickupMotor.set(-speed);
  }
  public void stopPickup(){
    m_pickupMotor.set(0.0);
    m_pickupMotor.stopMotor(); // Still extra safe
  }

  //drop  overhang
  public void disengageDrop(){
    dropOverhang.set(false);
  }
  public void engageDrop(){
    dropOverhang.set(true);
  } 
  
  //release line 
  public void spinLine(double speed){
    m_overhangMotor.set(-speed);
  }
  public void stopReleaseLine(){
    m_overhangMotor.set(0.0);
    m_overhangMotor.stopMotor(); // Still extra safe
  }

 
}
