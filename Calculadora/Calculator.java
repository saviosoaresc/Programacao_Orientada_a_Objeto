


import java.text.DecimalFormat;

class Calculator {
    public int batteryMax;
    public int battery;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0.0f;
    }

    public void chargeBattery(int value) { 
        if (value < 0)
            return;
        this.battery += value;
        if (this.battery > this.batteryMax)
            this.battery = this.batteryMax;
    }

    public boolean useBattery() { 
        if (this.battery == 0){
            System.out.println("fail: bateria insuficiente");
            return false;
        }
        this.battery -= 1;
        return true;
    }

    public void sum(int a, int b) { 
        if (useBattery())
            this.display = (a + b);
    }

    public void division(int num, int den) {
        if (!useBattery())
            return;
        if (den == 0){
            System.out.println("fail: divisao por zero");
        }
        else
            this.display = (float) num / den;
    }

    public String toString() { 
        DecimalFormat form = new DecimalFormat("0.00");
        return "display = " + form.format(this.display).replace(",", ".") + ", battery = " + this.battery;
    }
}