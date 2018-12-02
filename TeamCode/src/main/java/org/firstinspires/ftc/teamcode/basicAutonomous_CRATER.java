package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Date;

@Autonomous(name="AutoCrater")
public class basicAutonomous_CRATER extends OpMode {
    DcMotor extendo_arm;
    DcMotor leftDrive;
    DcMotor rightDrive;
    long waitTime = 0;
    long nextWaitTime = 0;
    int phase = 0;

    public void basicAutonomous() {

    }

    @Override
    public void init() {
        extendo_arm = hardwareMap.dcMotor.get("extendo_arm");
        extendo_arm.setDirection(DcMotor.Direction.REVERSE);
        leftDrive = hardwareMap.dcMotor.get("leftMotor");
        rightDrive = hardwareMap.dcMotor.get("rightMotor");
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
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
                        nextWaitTime = 2000;
                        break;
                    case 1:
                        extendo_arm.setPower(0.0);
                        leftDrive.setPower(-1.0);
                        rightDrive.setPower(1.0);
                        nextWaitTime = 1000;
                        break;
                    case 2:
                        leftDrive.setPower(-1.0);
                        rightDrive.setPower(-1.0);
                        nextWaitTime = 1000;
                        break;
                    case 3:
                        leftDrive.setPower(1.0);
                        rightDrive.setPower(-1.0);
                        nextWaitTime = 1000;
                        break;
                    case 4:
                        leftDrive.setPower(1.0);
                        rightDrive.setPower(1.0);
                        nextWaitTime = 5000;
                        break;
                    case 5:
                        leftDrive.setPower(0.0);
                        rightDrive.setPower(0.0);
                    default:
                        break;
                }
                waitTime = 0;
                phase++;
            }
        }
    }
}
