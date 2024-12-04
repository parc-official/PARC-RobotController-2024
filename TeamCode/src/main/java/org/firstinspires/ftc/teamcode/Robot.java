package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
    MecanumDrive drive;

    Intake intake;


    public boolean update = false;

    public Robot(Gamepad gamepad1, Gamepad gamepad2, DcMotor LFD, DcMotor LBD, DcMotor RFD, DcMotor RBD, Servo slide, Servo claw, BNO055IMU imu, HardwareMap hardwareMap, Telemetry telemetry) {
        drive = new MecanumDrive(gamepad1, LFD, LBD, RFD, RBD, imu, hardwareMap, telemetry);
        intake = new Intake(gamepad2, slide, claw, telemetry);
    }
    public Robot(DcMotor LFD, DcMotor LBD, DcMotor RFD, DcMotor RBD, Servo slide, Servo claw, BNO055IMU imu, HardwareMap hardwareMap, Telemetry telemetry) {
        drive = new MecanumDrive(LFD, LBD, RFD, RBD, imu, hardwareMap, telemetry);
        intake = new Intake(slide, claw, telemetry);
    }
    public void controllerMode() {
        drive.fieldCentricDrive();
        intake.intakeByController();
    }

}
