import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

class Robot extends TimedRobot{
  WPI_TalonSRX motorFL;
  WPI_TalonSRX motorFR;
  WPI_TalonSRX motorBL;
  WPI_TalonSRX motorBR;
  SpeedControllerGroup right;
  SpeedControllerGroup left;
  DifferentialDrive drive;
  XboxController controller;

  void robotInit(){
    motorFL = new WPI_TalonSRX(1);
    motorFR = new WPI_TalonSRX(2);
    motorBL = new WPI_TalonSRX(3);
    motorBL = new WPI_TalonSRX(4);

    controller = new XboxController(0);

    left = new SpeedControllerGroup(motorFL, motorBL);
    right = new SpeedControllerGroup(motorFR, motorBR);
    drive = newDifferentialDrive(left,right);
  }

  void teleopInit(){

  }
  void teleopPeriodic(){
    if(controller.getAButton()){
      double yValue = controller.getY(GenericHID.Hand.kLeft);
      double xValue = controller.getX(GenericHID.Hand.kLeft);
      drive.arcadeDrive(yValue, xValue);
    }
    if(controller.getBumper(GenericHID.Hand.kLeft)){
      double yValue = controller.getY(GenericHID.Hand.kLeft);
      double xValue = controller.getX(GenericHID.Hand.kRight);
      drive.arcadeDrive(yValue, xValue);
    }
    if(controller.getBumper(GenericHID.Hand.kRight)){
      double yValue = controller.getY(GenericHID.Hand.kRight);
      double xValue = controller.getX(GenericHID.Hand.kLeft);
      drive.arcadeDrive(yValue, xValue);
    }

  }
}

class Main {
  public static void main(String[] args) {
  
  }
}
