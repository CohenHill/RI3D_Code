package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

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

