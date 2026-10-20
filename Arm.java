package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.lib.generic.GenericSubsystem;
import static frc.robot.subsystems.arm.ArmConstants.ARM_MOTOR;

public class Arm extends GenericSubsystem {

    private Command stopMotor() {
        return Commands.runOnce(ARM_MOTOR::stopMotor, this);
    }

    private Command resetEncoder() {
        ARM_MOTOR.setMotorEncoderPosition(0);
        return null;
    }

}
