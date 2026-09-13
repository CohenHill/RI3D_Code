package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Flippers {

    public Servo pollenFlipper;
    public Servo nectorFlipper;
    public DistanceSensor pollenDistance;
    public DistanceSensor nectorDistance;

    public double pollenD;
    public double nectorD;

    ElapsedTime sleeptime = new ElapsedTime();

    public void init(HardwareMap hwMap) {
        pollenFlipper = hwMap.get(Servo.class, "franklin_flipper_right");
        nectorFlipper = hwMap.get(Servo.class, "franklin_flipper_left");

        pollenDistance = hwMap.get(DistanceSensor.class, "pollenDistance");
        nectorDistance = hwMap.get(DistanceSensor.class, "nectorDistance");
    }

    public void checkDistanceFlip () {
        pollenD = pollenDistance.getDistance(DistanceUnit.MM);
        nectorD = nectorDistance.getDistance(DistanceUnit.MM);
    }

    public void flip() {
        checkDistanceFlip();
        if(pollenD < 100){
            pollenFlipper.setPosition(0.11);
            sleep(500);
            pollenFlipper.setPosition(0.44);
        }
        else if(nectorD < 100){
            nectorFlipper.setPosition(1);
            sleep(500);
            nectorFlipper.setPosition(0.64);
        }
    }

    public void sleep(double time) {
        sleeptime.reset();
        while (sleeptime.milliseconds() <= time) {

        }
    }
}

