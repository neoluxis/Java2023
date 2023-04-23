package src.Play;

public class PidCalc {
    public static void main(String[] args) {

    }
}

class Pid {
    public double Kp;
    public double Ki;
    public double Kd;
    public double dt;
    public double error;
    public double errorSum;
    public double errorDiff;
    public double errorPrev;
    public double output;

    public Pid lastPid;

    public Pid(double Kp, double Ki, double Kd, double dt) {
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
        this.dt = dt;
    }
}