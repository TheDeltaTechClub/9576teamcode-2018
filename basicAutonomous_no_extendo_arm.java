package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Date;

@Autonomous(name="basicAutonomous")
public class basicAutonomous_no_extendo_arm extends OpMode {
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
