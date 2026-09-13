package org.firstinspires.ftc.teamcode.Util;

public class PIDFController {
    private double kP;
    private double kI;
    private double kD;
    private double kF;

    private double integral;
    private double previousError;

    private double setpoint;
    private double measuredValue;
    private double output;

    public PIDFController(double kP, double kI, double kD, double kF) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
    }

    public void reset() {
        integral = 0;
        previousError = 0;
    }

    public void update(double measuredValue) {
        this.measuredValue = measuredValue;
        double error = setpoint - measuredValue;
        integral += error;
        double derivative = error - previousError;
        output = kP * error + kI * integral + kD * derivative + kF;
        previousError = error;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double getOutput() {
        return output;
    }
}