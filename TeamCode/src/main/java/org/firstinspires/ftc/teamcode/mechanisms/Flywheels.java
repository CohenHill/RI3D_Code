package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Util.PIDFController;

public class Flywheels {

    public DcMotorEx launch_motor_1;
    public DcMotorEx launch_motor_2;
    private double Kp1 = 5,Ki1 = 0.0,Kd1 = 0.0,Kf1 = 0.0;
    private double Kp2 = 5,Ki2 = 0.0,Kd2 = 0.0,Kf2 = 0.0;
    public PIDFController flywheelController1, flywheelController2;

    private double currentVelocity1, currentVelocity2;
    private double output1, output2;

    private double targetVelocity1, targetVelocity2;
    private static final double MAX_RPM = 6000.0;

//    private static final double POLLEN_PERCENT = 0.80 * MAX_RPM;   // 80%
//    private static final double NECTAR_PERCENT = 0.55 * MAX_RPM;   // 55%
    private static final double POLLEN_PERCENT = 0.75;   // 80%
    private static final double NECTAR_PERCENT = 0.48;   // 55%

    private static final double POLLEN_RPM = MAX_RPM * POLLEN_PERCENT;   // 4800
    private static final double NECTAR_RPM = MAX_RPM * NECTAR_PERCENT;   // 3300
    private enum FlywheelState {
        POLLEN,
        NECTAR,
        STOPPED
    }
    private FlywheelState flywheelState = FlywheelState.STOPPED;

    public void init(HardwareMap hwMap) {
        launch_motor_1 = hwMap.get(DcMotorEx.class, "launch_motor_1");
        launch_motor_2 = hwMap.get(DcMotorEx.class, "launch_motor_2");

        launch_motor_1.setDirection(DcMotorSimple.Direction.REVERSE);
        launch_motor_1.setDirection(DcMotorSimple.Direction.REVERSE);

        flywheelController1 = new PIDFController(Kp1, Ki1, Kd1, Kf1);
        flywheelController2 = new PIDFController(Kp2, Ki2, Kd2, Kf2);

        launch_motor_1.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        launch_motor_2.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void Read(){
        currentVelocity1 = launch_motor_1.getVelocity();
        currentVelocity2 = launch_motor_2.getVelocity();
    }

    public void Loop(){
        switch (flywheelState) {
            case POLLEN:
                targetVelocity1 = POLLEN_RPM;
                targetVelocity2 = POLLEN_RPM;
                flywheelController1.setSetpoint(targetVelocity1);
                flywheelController2.setSetpoint(targetVelocity2);
                break;
            case NECTAR:
                targetVelocity1 = NECTAR_RPM;
                targetVelocity2 = NECTAR_RPM;
                flywheelController1.setSetpoint(targetVelocity1);
                flywheelController2.setSetpoint(targetVelocity2);
                break;
            case STOPPED:
            default:
                targetVelocity1 = 0;
                targetVelocity2 = 0;
                flywheelController1.setSetpoint(targetVelocity1);
                flywheelController2.setSetpoint(targetVelocity2);
                break;
        }

        flywheelController1.update(currentVelocity1);
        flywheelController2.update(currentVelocity2);

        output1 = flywheelController1.getOutput();
        output2 = flywheelController2.getOutput();
    }

    public void Write(){
        launch_motor_1.setPower(Math.max(0, Math.min(1, output1)));
        launch_motor_2.setPower(Math.max(0, Math.min(1, output2)));
    }

    public void setTargetVelocity(double velocity1, double velocity2) {
        targetVelocity1 = velocity1;
        targetVelocity2 = velocity2;
    }
    public void setTargetVelocity1(double velocity1) {
        targetVelocity1 = velocity1;
    }
    public void setTargetVelocity2(double velocity2) {
        targetVelocity2 = velocity2;
    }

    public void setPollenPercent(){
//        targetVelocity1 = POLLEN_RPM;
//        targetVelocity2 = POLLEN_RPM;
        launch_motor_1.setPower(POLLEN_PERCENT);
        launch_motor_2.setPower(POLLEN_PERCENT);
    }
    public void setNectarPercent(){
//        targetVelocity1 = NECTAR_RPM;
//        targetVelocity2 = NECTAR_RPM;
        launch_motor_1.setPower(NECTAR_PERCENT);
        launch_motor_2.setPower(NECTAR_PERCENT);
    }

    public void setPowerZero(){
        launch_motor_1.setPower(0);
        launch_motor_2.setPower(0);
    }


}
