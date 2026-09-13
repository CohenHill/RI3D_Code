package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.config;
import org.firstinspires.ftc.teamcode.mechanisms.Flippers;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Flywheels;
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain;



@TeleOp(name = "Teleop", group = "Robot")
public class Teleop extends OpMode {

    config conf = new config();
    double forward, strafe, rotate;


    @Override
    public void init() {
        conf.init(hardwareMap);
        conf.flippers.checkDistanceFlip();
        telemetry.addData("Distance Sensor", conf.flippers.distanceFlipSaved);
        telemetry.update();
    }

    public void start(){
        conf.drivetrain.limelight.start();

    }

    @Override
    public void loop() {
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        if(gamepad1.right_trigger > 0.5){
            conf.flippers.flip();
        }
        if(gamepad1.left_trigger > 0.5){
            conf.intake.setIntakeState(Intake.IntakeState.ACTIVE);
        }


        conf.drivetrain.drive(forward, strafe, rotate);

        conf.intake.Loop();


    }
}
