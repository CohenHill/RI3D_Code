package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class config {

    public Drivetrain drivetrain = new Drivetrain();
    public Intake intake = new Intake();
    public Flywheels flywheels = new Flywheels();
    public Flippers flippers = new Flippers();

    public void init(HardwareMap hwMap) {
        drivetrain.init(hwMap);
        intake.init(hwMap);
        flywheels.init(hwMap);
        flippers.init(hwMap);
    }

}

