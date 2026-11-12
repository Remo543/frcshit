package frc.robot.subsystems.arm;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.lib.generic.GenericSubsystem;
import frc.lib.generic.hardware.motor.MotorProperties;
import frc.robot.subsystems.arm.ArmConstants.*;
import org.littletonrobotics.junction.Logger;

import java.util.ArrayList;

import static frc.robot.subsystems.arm.ArmConstants.ARM_MECHANISM;
import static frc.robot.subsystems.arm.ArmConstants.ARM_MOTOR;

public class Arm extends GenericSubsystem {
    public Command setTargetPosition(double targetAngle){
        return Commands.runOnce(() -> {
            ARM_MOTOR.setOutput(MotorProperties.ControlMode.POSITION, targetAngle / 360);
            stopMotor();
        });
    }

    public Command stopMotor() {
        return Commands.runOnce(ARM_MOTOR::stopMotor);
    };

    public void periodic() {
        ARM_MECHANISM.updateCurrentAngle(Rotation2d.fromDegrees(ARM_MOTOR.getSystemPosition() * 360));
        ArrayList<Pose3d> a = ARM_MECHANISM.armMechanism.generate3dMechanism();
        Pose3d[] poses = new Pose3d[a.size()];
        for (int i = 0; i < a.size(); i++) {
            poses[i] = a.get(i);
        }
        Logger.recordOutput("Arm/MechanismPoses", poses);
    }

}
