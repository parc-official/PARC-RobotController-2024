package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name = "TeleOpMode", group = "TeleOpModes")
public class TeleOpMode extends LinearOpMode {

    Robot robot;
    public void init(Gamepad gamepad1, Gamepad gamepad2, HardwareMap hardwareMap) {
        robot = new Robot(gamepad1, hardwareMap.get(DcMotor.class, "LFD"), hardwareMap.get(DcMotor.class, "LBD"), hardwareMap.get(DcMotor.class, "RFD"), hardwareMap.get(DcMotor.class, "RBD"), hardwareMap.get(DcMotor.class, "spinner"), new DcMotor[] {hardwareMap.get(DcMotor.class, "liftl"), hardwareMap.get(DcMotor.class, "liftr")}, hardwareMap.get(Servo.class, "drop"), hardwareMap.get(BNO055IMU.class, "imu"), hardwareMap);
        telemetry.setMsTransmissionInterval(250);
    }

    public void runOpMode() {
        robot = new Robot(gamepad1, hardwareMap.get(DcMotor.class, "LFD"), hardwareMap.get(DcMotor.class, "LBD"), hardwareMap.get(DcMotor.class, "RFD"), hardwareMap.get(DcMotor.class, "RBD"), hardwareMap.get(DcMotor.class, "spinner"), new DcMotor[] {hardwareMap.get(DcMotor.class, "liftl"), hardwareMap.get(DcMotor.class, "liftr")}, hardwareMap.get(Servo.class, "drop"), hardwareMap.get(BNO055IMU.class, "imu"), hardwareMap);
        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                robot.controllerMode();
            }
        }
        /*
        if (robot.update) {
            telemetry.addLine(robot.message);
            robot.update = false;
            telemetry.update();
        }
         */
    }
}
