package frc.robot.subsystems.arm;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import frc.lib.generic.hardware.motor.*;
import frc.lib.generic.simulation.SimProperties;
import frc.lib.generic.visualization.mechanisms.MechanismFactory;
import frc.lib.generic.visualization.mechanisms.SingleJointedArmMechanism2d;

import static edu.wpi.first.math.system.plant.DCMotor.getFalcon500;
import static frc.lib.generic.simulation.SimProperties.SimulationType.SIMPLE_MOTOR;

public class ArmConstants {
    protected static final Motor ARM_MOTOR = MotorFactory.createTalonFX("ARM_MOTOR", 2);
    protected static final SingleJointedArmMechanism2d ARM_MECHANISM = MechanismFactory.createSingleJointedArmMechanism("Arm Mechanism", 2);

    protected static final Rotation2d
            MAX_ANGLE = Rotation2d.fromDegrees(270),
            MIN_ANGLE = Rotation2d.fromDegrees(-270);

    protected static final double MIN_ANGLE_ROT = MIN_ANGLE.getRotations();
    protected static final double MAX_ANGLE_ROT = MAX_ANGLE.getRotations();

    static {
        configureArmMotor();
    }

    private static void configureArmMotor() {
        final MotorConfiguration configuration = new MotorConfiguration();

        configuration.idleMode = MotorProperties.IdleMode.BRAKE;


        configuration.slot = new MotorProperties.Slot(34, 0, 0.18, 2.9749, 0, 0.22603);

        configuration.simulationSlot = new MotorProperties.Slot(5, 0, 0.005, 11.22, 0, 0);
        configuration.simulationProperties = new SimProperties.Slot (
                SimProperties.SimulationType.ARM,
                DCMotor.getFalcon500(1),
                1,
                0.5,
                0.01,
                Rotation2d.fromRotations(MIN_ANGLE.getRotations()),
                Rotation2d.fromRotations(MAX_ANGLE.getRotations()),
                true
        );

        ARM_MOTOR.configure(configuration);

        ARM_MOTOR.setMotorEncoderPosition(0);

        ARM_MOTOR.setupSignalUpdates(MotorSignal.CURRENT);
        ARM_MOTOR.setupSignalUpdates(MotorSignal.POSITION);
        ARM_MOTOR.setupSignalUpdates(MotorSignal.VELOCITY);
        ARM_MOTOR.setupSignalUpdates(MotorSignal.VOLTAGE);
        ARM_MOTOR.setupSignalUpdates(MotorSignal.ACCELERATION);
        ARM_MOTOR.setupSignalUpdates(MotorSignal.CLOSED_LOOP_TARGET);
    }

}
