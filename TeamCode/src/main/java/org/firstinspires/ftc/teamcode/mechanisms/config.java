package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class config {

    Drivetrain drivetrain = new Drivetrain();
    Intake intake = new Intake();
    Flywheels flywheels = new Flywheels();
    Flippers flippers = new Flippers();

    public void init(HardwareMap hwMap) {
        drivetrain.init(hwMap);
        intake.init(hwMap);
        flywheels.init(hwMap);
        flippers.init(hwMap);


    }
}

