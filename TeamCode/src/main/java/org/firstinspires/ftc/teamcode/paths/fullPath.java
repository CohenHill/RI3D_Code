package org.firstinspires.ftc.teamcode.paths;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedro.Constants;


@Autonomous(name = "FullAuto", group = "Autonomous")
public class fullPath extends LinearOpMode {

    private Follower follower;
    private final full paths = new full();   // your path class

    @Override
    public void runOpMode() {

        follower = Constants.create(hardwareMap);
        follower.setPose(full.startp);   // starting pose
        follower.update();

        waitForStart();

        if (opModeIsActive()) {

            // PATH 1
            follower.follow(paths.path1());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 2
            follower.follow(paths.path2());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 3
            follower.follow(paths.path3());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 4
            follower.follow(paths.path4());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 5
            follower.follow(paths.path5());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 6
            follower.follow(paths.path6());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 7
            follower.follow(paths.path7());
            while (opModeIsActive() && follower.isBusy()) follower.update();

            // PATH 8
            follower.follow(paths.path8());
            while (opModeIsActive() && follower.isBusy()) follower.update();
        }

        // TELEMETRY LOOP ONLY
        while (opModeIsActive()) {
            follower.update();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());
            telemetry.update();
        }
    }
}
