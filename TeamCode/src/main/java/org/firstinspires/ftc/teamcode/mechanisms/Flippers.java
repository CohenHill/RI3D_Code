package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Flippers {

    public Servo flipper;
//    public DistanceSensor distanceFlip;
    public double distanceFlipSaved;

    ElapsedTime sleeptime = new ElapsedTime();

    Flywheels flywheels = new Flywheels();

    public void init(HardwareMap hwMap) {
        flipper = hwMap.get(Servo.class, "flipper");

//        distanceFlip = hwMap.get(DistanceSensor.class, "distanceFlip");

        flywheels.init(hwMap);
    }

    public void checkDistanceFlip () {
//        distanceFlipSaved = distanceFlip.getDistance(DistanceUnit.MM);
    }

    public void flip() {
        checkDistanceFlip();
        if(distanceFlipSaved < 100){
            flipper.setPosition(0.9);
            sleep(500);
            flipper.setPosition(0.6);
        }
    }

    public void whatBall(){
        checkDistanceFlip();
        if(distanceFlipSaved < 5){
            flywheels.setTargetVelocity(1500,1500);
        }
        else if( distanceFlipSaved < 2.5){
            flywheels.setTargetVelocity(1500,1500);
        }
    }

    public void sleep(double time) {
        sleeptime.reset();
        while (sleeptime.milliseconds() <= time) {

        }
    }
}

