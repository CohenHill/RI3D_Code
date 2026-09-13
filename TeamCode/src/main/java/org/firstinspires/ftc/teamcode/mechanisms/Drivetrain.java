package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import java.util.List;

public class Drivetrain {

    public DcMotor back_left_drive;
    public DcMotor front_left_drive;
    public DcMotor back_right_drive;
    public DcMotor front_right_drive;
    public Limelight3A limelight;
    public int tagl = 0;
    public double cameraHeight = 26.67; //CM
    public double cameraAngle = 6; //90 minus tilt
    public double goalHeight = 139.7;
    public double distance = 0;
    public double id = 0;
    public double maxPower;

    public void init(HardwareMap hwMap) {
        back_left_drive = hwMap.get(DcMotor.class, "back_left_drive");
        front_left_drive = hwMap.get(DcMotor.class, "front_left_drive");
        back_right_drive = hwMap.get(DcMotor.class, "back_right_drive");
        front_right_drive = hwMap.get(DcMotor.class, "front_right_drive");
        limelight = hwMap.get(Limelight3A.class, "limelight");
    }

    public void getDistance(){
        //LLResult llResult = limelight.getLatestResult();

        LLResult llresult = limelight.getLatestResult();
        List<LLResultTypes.FiducialResult> fiducials = llresult.getFiducialResults();
        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            tagl = fiducial.getFiducialId(); // The ID number of the fiducial
        }

        double ty = llresult.getTy();

        double angleToTarget = cameraAngle + ty;
        double heightDifference = goalHeight - cameraHeight;


        if (tagl > 0) {
            distance = heightDifference / Math.tan(Math.toRadians(angleToTarget));
        }
    }

    public void ReadTag() {
        LLResult llresult = limelight.getLatestResult();
        List<LLResultTypes.FiducialResult> fiducials = llresult.getFiducialResults();
        for (LLResultTypes.FiducialResult fiducial : fiducials) {
            id = fiducial.getFiducialId(); // The ID number of the fiducial
        }
    }

    public void drive(double forward, double strafe, double rotate) {
        double front_left_power = forward + strafe - rotate;
        double front_right_power = forward - strafe + rotate;
        double back_right_power = forward + strafe + rotate;
        double back_left_power = forward - strafe - rotate;

        maxPower = 1;
        maxPower = Math.max(maxPower, Math.abs(front_left_power));
        maxPower = Math.max(maxPower, Math.abs(front_right_power));
        maxPower = Math.max(maxPower, Math.abs(back_right_power));
        maxPower = Math.max(maxPower, Math.abs(back_left_power));

        front_left_drive.setPower(front_left_power / maxPower);
        back_left_drive.setPower(back_left_power / maxPower);
        front_right_drive.setPower(front_right_power / maxPower);
        back_right_drive.setPower(back_right_power / maxPower);
    }
}

