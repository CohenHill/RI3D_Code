package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
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
        rotate = -gamepad1.right_stick_x;

        if(gamepad1.right_trigger > 0.5){
            conf.flippers.flipper.setPosition(0.9);
            telemetry.addLine("flipping");
        }
        else{
            conf.flippers.flipper.setPosition(0.6);
            telemetry.addLine("not flipping");
        }

        if(gamepad1.left_trigger > 0.5){
            conf.intake.setIntakeState(Intake.IntakeState.ACTIVE);
            telemetry.addLine("intake Active");
        } else {
            conf.intake.setIntakeState(Intake.IntakeState.STOPPED);
            telemetry.addLine("intake Stopped");
        }

        if (gamepad1.a){
            //conf.flywheels.setPollenPercent();
            conf.flywheels.launch_motor_1.setPower(.75);
            conf.flywheels.launch_motor_2.setPower(.79);
            telemetry.addLine("Flywheel Pollen");
            telemetry.addData("Pollen V1", conf.flywheels.launch_motor_1.getVelocity());
            telemetry.addData("Pollen V2", conf.flywheels.launch_motor_2.getVelocity());
        }
        if (gamepad1.x){
            //conf.flywheels.setNectarPercent();
            conf.flywheels.launch_motor_1.setPower(.48);
            conf.flywheels.launch_motor_2.setPower(.52);
            telemetry.addLine("Flywheel nectar");
            telemetry.addData("Nector V1", conf.flywheels.launch_motor_1.getVelocity());
            telemetry.addData("Nector V2", conf.flywheels.launch_motor_2.getVelocity());
        }
        if (gamepad1.b){
//            conf.flywheels.setTargetVelocity(0,0);
            conf.flywheels.setPowerZero();
            telemetry.addLine("Flywheel Off");
        }

        conf.flywheels.Read();
        conf.flywheels.Loop();
        conf.flywheels.Write();

        conf.drivetrain.drive(forward, strafe, rotate);

        conf.intake.Loop();


    }
}
