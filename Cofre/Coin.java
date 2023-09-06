package Cofre;

import java.text.DecimalFormat;

public class Coin {
    String label;
    double value;
    int volume;

    public Coin(String label, double value, int volume) {
        this.label = label;
        this.value = value;
        this.volume = volume;
    }
        
    @Override
    public String toString(){
        DecimalFormat form = new DecimalFormat("0.00");
        String ss = "";
        ss +=  form.format(value).replace(",", ".") + ":" + volume;
        return ss;
    }
    
    
    
    //    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }
//
//    public double getValue() {
//        return value;
//    }
//
//    public void setValue(double value) {
//        this.value = value;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
}
