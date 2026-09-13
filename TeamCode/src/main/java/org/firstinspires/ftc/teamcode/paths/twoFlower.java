package org.firstinspires.ftc.teamcode.paths;

import static com.pedropathing.api.Paths.*;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class twoFlower {

    private static final PoseFactory poseFactory = PoseFactory.degrees();

    public static final Pose start = poseFactory.of(56, 8, 90);
    private static final Pose launch_initial = poseFactory.of(56, 10, 90);
    private static final Pose flower1 = poseFactory.of(8.5, 47, 180);
    private static final Pose launchFlower1 = poseFactory.of(30, 110, 310);
    private static final Pose flower2 = poseFactory.of(47, 133, 90);
    private static final Pose launchFlower2 = poseFactory.of(30, 110, 310);
    private static final Pose parking = poseFactory.of(15, 110, 310);

    private static final Pose flower1_control = poseFactory.of(54, 45, 0);

    public static Path launchInitial() {
        return line(start, launch_initial).constant(launch_initial);
    }

    public static Path flower1() {
        return curve(launch_initial, flower1_control, flower1).linear(launch_initial, flower1);
    }

    public static Path launchFlower1() {
        return line(flower1, launchFlower1).linear(flower1, launchFlower1);
    }

    public static Path path4() {
        return line(launchFlower1, flower2).linear(launchFlower1, flower2);
    }

    public static Path path5() {
        return line(flower2, launchFlower2).linear(flower2, launchFlower2);
    }

    public static Path path6() {
        return line(launchFlower2, parking).constant(parking);
    }
}