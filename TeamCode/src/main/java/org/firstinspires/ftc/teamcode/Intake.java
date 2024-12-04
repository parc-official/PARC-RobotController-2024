package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    Servo slide;
    Servo claw;
    Gamepad gamepad2;
    Telemetry telemetry;
    ElapsedTime time1;
    ElapsedTime time2;

    boolean apressed = false;
    boolean bpressed = false;
    boolean xpressed = false;
    boolean ypressed = false;

    public Intake(Gamepad gamepad2, Servo slide, Servo claw, Telemetry telemetry){
        this.gamepad2 = gamepad2;
        this.slide = slide;
        this.claw = claw;
        this.telemetry = telemetry;
        time1 = new ElapsedTime();
        time2 = new ElapsedTime();
    }

    public Intake(Servo slide, Servo claw, Telemetry telemetry){
        this.slide = slide;
        this.claw = claw;
    }

    public void intakeByController(){
        try {
            if (gamepad2.b && !bpressed && time1.milliseconds() > 100){
                bpressed = true;
                slide.setPosition(0.600);
                time1.reset();
            } else if (gamepad2.a && !apressed && time1.milliseconds() > 100){
                apressed = true;
                slide.setPosition(0.880);
                time1.reset();
            } else if (gamepad2.y && !ypressed && time2.milliseconds() > 100){
                ypressed = true;
                claw.setPosition(0.124);
                time2.reset();
            } else if (gamepad2.x && !xpressed && time2.milliseconds() > 100){
                xpressed = true;
                claw.setPosition(0.1425);
                time2.reset();
            }

            telemetry.addData("Time", time1);
            telemetry.update();

            if (!gamepad2.b) bpressed = false;
            if (!gamepad2.a) apressed = false;
            if (!gamepad2.y) ypressed = false;
            if (!gamepad2.x) xpressed = false;

        } catch (Exception e){
            telemetry.addLine(e.getMessage());
            telemetry.update();
        }
    }
}
