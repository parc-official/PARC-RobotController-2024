package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

@Autonomous
public class AutoTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        IMU imu = hardwareMap.get(IMU.class, "BNO055IMU");
        //imu.initialize;
        RRMecanumDrive drive = new RRMecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        waitForStart();
        Actions.runBlocking(new SequentialAction(
                drive.turn(Math.PI / 2)
        ));
    }
}
