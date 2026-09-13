package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    public DcMotor intake_motor;
    private double activePower = 1.0;
    private double passivePower = 0.3;
    private double stoppedPower = 0.0;
    public void init(HardwareMap hwMap) {
        intake_motor = hwMap.get(DcMotor.class, "intake_motor");
    }
    public enum IntakeState {
        ACTIVE,
        PASSIVE,
        STOPPED
    }
    private IntakeState intakeState = IntakeState.STOPPED;
    public void Loop(){
        switch(intakeState){
            case ACTIVE:
                intake_motor.setPower(activePower);
                break;
            case PASSIVE:
                intake_motor.setPower(passivePower);
                break;
            case STOPPED:
                intake_motor.setPower(stoppedPower);
                break;
        }
    }

    public void setIntakeState(IntakeState newState){
        intakeState = newState;
    }

}

