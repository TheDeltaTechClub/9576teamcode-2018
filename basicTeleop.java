package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="basicTeleop")
public class basicTeleop extends OpMode {

        DcMotor leftDrive;
        DcMotor rightDrive;

        public void basicTeleop() {
//
        }

        @Override
        public void init() {
            leftDrive = hardwareMap.dcMotor.get("leftMotor");
            rightDrive = hardwareMap.dcMotor.get("rightMotor");
            leftDrive.setDirection(DcMotor.Direction.FORWARD);
            rightDrive.setDirection(DcMotor.Direction.REVERSE);
            telemetry.addData("Init finished.", "");
            telemetry.update();
        }

        @Override
        public void loop() {
            float left = gamepad1.left_stick_y;
            float right = gamepad1.right_stick_y;

            left = Range.clip(left, -1, 1);
            right = Range.clip(right, -1, 1);

            leftDrive.setPower(left);
            rightDrive.setPower(right);
        }

        @Override
        public void stop() {

        }
}
