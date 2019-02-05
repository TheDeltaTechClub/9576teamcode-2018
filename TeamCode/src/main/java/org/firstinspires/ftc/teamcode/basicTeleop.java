package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="9576Teleop")
public class basicTeleop extends OpMode {

        DcMotor extendo_arm; // the thing that hooks onto the lander
        DcMotor leftDrive;
        DcMotor rightDrive;
        DcMotor flippyDo; // the thing that pushes the objects and spins around

        public void basicTeleop() {

        }

        @Override
        public void init() {
            extendo_arm = hardwareMap.dcMotor.get("extendo_arm");
            leftDrive = hardwareMap.dcMotor.get("leftMotor");
            rightDrive = hardwareMap.dcMotor.get("rightMotor");
            flippyDo = hardwareMap.dcMotor.get("flippyDo");
            extendo_arm.setDirection(DcMotor.Direction.REVERSE);
            leftDrive.setDirection(DcMotor.Direction.FORWARD);
            rightDrive.setDirection(DcMotor.Direction.REVERSE);
            flippyDo.setDirection(DcMotor.Direction.FORWARD);
            telemetry.addData("Init finished.", "");
            telemetry.update();
        }

        @Override
        public void loop() {
            float left = gamepad1.left_stick_y;
            float right = gamepad1.right_stick_y;
            boolean extendo_up = gamepad1.left_bumper;
            boolean extendo_down = gamepad1.left_trigger>0.1;
            boolean flippyDo_up = gamepad1.right_bumper;
            boolean flippyDo_down = gamepad1.right_trigger>0.1;

            left = Range.clip(left, -1, 1);
            right = Range.clip(right, -1, 1);

            leftDrive.setPower(left);
            rightDrive.setPower(right);
            if (extendo_up&&!extendo_down) {
                extendo_arm.setPower(1.0);
            } else if (extendo_down&&!extendo_up) {
                extendo_arm.setPower(-1.0);
            } else {
                extendo_arm.setPower(0.0);
            }

            if (flippyDo_up&&!extendo_down) {
                flippyDo.setPower(1.0);
            } else if (flippyDo_down&&!flippyDo_up) {
                flippyDo.setPower(-1.0);
            } else {
                flippyDo.setPower(0.0);
            }
        }

        @Override
        public void stop() {

        }
}
