package org.firstinspires.ftc.teamcode.paths;
import static com.pedropathing.api.Paths.*;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class full {

    private static final PoseFactory poseFactory = PoseFactory.degrees();

    public static final Pose startp = poseFactory.of(57, 8.5, 90);
    private static final Pose garden = poseFactory.of(27, 8.5, 180);
    private static final Pose intake_garden = poseFactory.of(8.5, 8.5, 180);
    private static final Pose launch_garden = poseFactory.of(28, 23, 53);
    private static final Pose intake_flower = poseFactory.of(10, 47, 180);
    private static final Pose launch_flower = poseFactory.of(39, 112, 310);
    private static final Pose intake_flower_again = poseFactory.of(47, 130, 90);
    private static final Pose launch_final = poseFactory.of(39, 112, 310);
    private static final Pose parking = poseFactory.of(15, 112, 310);

    private static final Pose garden_control = poseFactory.of(60, 20, 0);
    private static final Pose control = poseFactory.of(37, 51, 0);
    private static final Pose flower_control = poseFactory.of(30, 47, 0);


    public Path path1() {
        return curve(startp, garden_control, garden).linear(startp, garden);
    }

    public Path path2() {
        return line(garden, intake_garden).constant(intake_garden);
    }

    public Path path3() {
        return line(intake_garden, launch_garden).linear(intake_garden, launch_garden);
    }

    public Path path4() {
        return curve(launch_garden, control, intake_flower).linear(launch_garden, intake_flower);
    }

    public Path path5() {
        return curve(intake_flower, flower_control, launch_flower).linear(intake_flower, launch_flower);
    }

    public Path path6() {
        return line(launch_flower, intake_flower_again).linear(launch_flower, intake_flower_again);
    }

    public Path path7() {
        return line(intake_flower_again, launch_final).linear(intake_flower_again, launch_final);
    }

    public Path path8() {
        return line(launch_final, parking).constant(parking);
    }
}