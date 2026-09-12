package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Drivetrain {

    public DcMotor back_left_drive;
    public DcMotor front_left_drive;
    public DcMotor back_right_drive;
    public DcMotor front_right_drive;
    public DcMotorEx launch_motor_1;
    public DcMotorEx launch_motor_2;
    public DcMotor intake_motor;
    public Servo franklin_flipper_right;
    public Servo franklin_flipper_left;
    public Limelight3A limelight;
    public DistanceSensor pollenDistance;
    public DistanceSensor nectorDistance;

    public void init(HardwareMap hwMap) {
        back_left_drive = hwMap.get(DcMotor.class, "back_left_drive");
        front_left_drive = hwMap.get(DcMotor.class, "front_left_drive");
        back_right_drive = hwMap.get(DcMotor.class, "back_right_drive");
        front_right_drive = hwMap.get(DcMotor.class, "front_right_drive");
        launch_motor_1 = hwMap.get(DcMotorEx.class, "launch_motor_1");
        launch_motor_2 = hwMap.get(DcMotorEx.class, "launch_motor_2");
        intake_motor = hwMap.get(DcMotor.class, "intake_motor");
        franklin_flipper_right = hwMap.get(Servo.class, "franklin_flipper_right");
        franklin_flipper_left = hwMap.get(Servo.class, "franklin_flipper_left");
        limelight = hwMap.get(Limelight3A.class, "limelight");
        pollenDistance = hwMap.get(DistanceSensor.class, "pollenDistance");
        nectorDistance = hwMap.get(DistanceSensor.class, "nectorDistance");
    }
}

