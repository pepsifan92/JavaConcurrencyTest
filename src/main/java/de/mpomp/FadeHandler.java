package de.mpomp;

public class FadeHandler implements Runnable {
    private Integer pwmValueSetpoint;
    private Integer pwmValueActual;

    public FadeHandler(Integer pwmValueSetpoint) {
        this.pwmValueActual = 0;
        this.pwmValueSetpoint = pwmValueSetpoint;
    }

    @Override
    public void run() {
        System.out.println("FadeHandler started with setpoint: " + pwmValueSetpoint);

        while (true) {
            if (pwmValueSetpoint > pwmValueActual) { // FadeUp
                pwmValueActual++;
                System.out.println("Setpoint: " + pwmValueSetpoint + ". Value: " + pwmValueActual);
            } else if (pwmValueSetpoint < pwmValueActual) { // FadeDown
                pwmValueActual--;
                System.out.println("Setpoint: " + pwmValueSetpoint + ". Value: " + pwmValueActual);
            } else {
                // Equal
            }


            sleep(1000);
        }
    }

    // synchronized guarantees that only one thread can enter this method at the same time
    synchronized void setValue(Integer pwmValue){
        pwmValueSetpoint = pwmValue;
    }

    private void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
