package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Date;

@Autonomous(name="basicAutonomous")
public class basicAutonomous extends OpMode {
    DcMotor extendo_arm;
    long waitTime = 0;
    long nextWaitTime = 0;
    int phase = 0;

    public void basicAutonomous() {

    }

    @Override
    public void init() {
        extendo_arm = hardwareMap.dcMotor.get("extendo_arm");
        extendo_arm.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Status:", "Loaded variables and ready for loop");
        telemetry.update();
    }

    public void loop() {
        Date date = new Date();
        long timeMilli = date.getTime();
        if (waitTime == 0) {
            waitTime = date.getTime()+nextWaitTime;
        } else {
            if (timeMilli >= waitTime) {
                switch (phase) {
                    case 0:
                        extendo_arm.setPower(1.0);
                        nextWaitTime = 1200;
                        break;
                    case 1:
                        extendo_arm.setPower(0.0);
                        break;
                    default:
                        break;
                }
                waitTime = 0;
                phase++;
            }
        }
    }
}
