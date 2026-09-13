package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Util.PIDFController;

public class Flywheels {

    public DcMotorEx launch_motor_1;
    public DcMotorEx launch_motor_2;
    private double Kp1 = 0.0,Ki1 = 0.0,Kd1 = 0.0,Kf1 = 0.0;
    private double Kp2 = 0.0,Ki2 = 0.0,Kd2 = 0.0,Kf2 = 0.0;
    public PIDFController flywheelController1, flywheelController2;

    private double currentVelocity1, currentVelocity2;
    private double output1, output2;

    private double targetVelocity1, targetVelocity2;

    public void init(HardwareMap hwMap) {
        launch_motor_1 = hwMap.get(DcMotorEx.class, "launch_motor_1");
        launch_motor_2 = hwMap.get(DcMotorEx.class, "launch_motor_2");

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
        flywheelController1.setSetpoint(targetVelocity1);
        flywheelController2.setSetpoint(targetVelocity2);

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


}
