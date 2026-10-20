package frc.robot.subsystems.arm;

import frc.lib.generic.hardware.motor.Motor;
import frc.lib.generic.hardware.motor.MotorConfiguration;
import frc.lib.generic.hardware.motor.MotorFactory;
import frc.lib.generic.hardware.motor.MotorProperties;
import frc.lib.generic.simulation.SimProperties;

import static edu.wpi.first.math.system.plant.DCMotor.getNeoVortex;
import static frc.lib.generic.simulation.SimProperties.SimulationType.SIMPLE_MOTOR;

public class ArmConstants {
    protected static final Motor ARM_MOTOR = MotorFactory.createTalonFX("ARM_MOTOR", 2);

    static {
        configureArmMotor();
    }

    private static void configureArmMotor() {
        final MotorConfiguration config = new MotorConfiguration();

        config.slot = new MotorProperties.Slot(1, 0, 0, 0, 0, 0);
        config.idleMode = MotorProperties.IdleMode.COAST;

        config.simulationSlot = new MotorProperties.Slot(1, 0, 0, 0, 0, 0);
        config.simulationProperties = new SimProperties.Slot(SIMPLE_MOTOR, getNeoVortex(1), 0, 0);

        ARM_MOTOR.configure(config);
    }
}
