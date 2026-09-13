package org.firstinspires.ftc.teamcode.paths;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.paths.twoFlower;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@Autonomous(name = "AutoPath", group = "Autonomous")
public class twoFlowerPath extends LinearOpMode {

    private Follower follower;

    @Override
    public void runOpMode() {
        follower = Constants.create(hardwareMap);
        follower.setPose(twoFlower.start);
        follower.update();



        waitForStart();
        if (opModeIsActive()) {

            // 1. Launch initial
            follower.follow(twoFlower.launchInitial());
            while (opModeIsActive() && follower.isBusy()) {
                follower.update();
            }

            // 2. Go to Flower 1
            follower.follow(twoFlower.flower1());
            while (opModeIsActive() && follower.isBusy()) {
                follower.update();
            }

            // 3. Launch from Flower 1
            follower.follow(twoFlower.launchFlower1());
            while (opModeIsActive() && follower.isBusy()) {
                follower.update();
            }

            // 4. Go to Flower 2
            follower.follow(twoFlower.path4());
            while (opModeIsActive() && follower.isBusy()) {
                follower.update();
            }

            // 5. Launch from Flower 2
            follower.follow(twoFlower.path5());
            while (opModeIsActive() && follower.isBusy()) {
                follower.update();
            }

            // 6. Park
            follower.follow(twoFlower.path6());
            while (opModeIsActive() && follower.isBusy()) {
                follower.update();
            }
        }
        while (opModeIsActive()) {
            follower.update();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());

            if (follower.currentPath() != null) {
                telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
                telemetry.addData("Path number", follower.pathIndex());
            }

            telemetry.update();
        }
    }
}
