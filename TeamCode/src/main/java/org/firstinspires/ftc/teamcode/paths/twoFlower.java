package org.firstinspires.ftc.teamcode.paths;

import static com.pedropathing.api.Paths.*;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class twoFlower {

    private static final PoseFactory poseFactory = PoseFactory.degrees();

    public static final Pose start = poseFactory.of(56, 8, 90);
    private static final Pose launch_initial = poseFactory.of(56, 10, 90);
    private static final Pose flower1 = poseFactory.of(10, 47, 180);
    private static final Pose turn1 = poseFactory.of(15,77.75,180);
    private static final Pose launchFlower1 = poseFactory.of(30, 110, 310);
    private static final Pose flower2 = poseFactory.of(47, 128, 90);
    private static final Pose turn2 = poseFactory.of(47, 120,90);
    private static final Pose launchFlower2 = poseFactory.of(30, 110, 310);
    private static final Pose parking = poseFactory.of(15, 110, 310);

    private static final Pose flower1_control = poseFactory.of(54, 45, 0);

    public static Path launchInitial() {
        return line(start, launch_initial).constant(launch_initial);
    }

    public static Path flower1() {
        return curve(launch_initial, flower1_control, flower1).linear(launch_initial, flower1);
    }

    public static Path turn1() {
        return line(flower1,turn1).linear(flower1,turn1);
    }

    public static Path launchFlower1() {
        return line(turn1, launchFlower1).constant(launchFlower1);
    }

    public static Path path4() {
        return line(launchFlower1, flower2).constant(flower2);
    }

    public static Path turn2() {
        return line(flower2,turn2).constant(turn2);
    }
    public static Path path5() {
        return line(turn2, launchFlower2).constant(launchFlower2);
    }

    public static Path path6() {
        return line(launchFlower2, parking).constant(parking);
    }
}