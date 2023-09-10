package Lapiseira;

import java.text.DecimalFormat;

public class Lead {
    private final float calibre;
    private final String dureza;
    private int size;

    public Lead(float calibre, String dureza, int size) {
        this.calibre = calibre;
        this.dureza = dureza;
        this.size = size;
    }

    public int usagePerSheet() {
        switch (dureza) {
            case "HB" : {
                return 1;
            }
            case "2B" : {
                return 2;
            }
            case "4B" : {
                return 4;
            }
            default : {
                return 6;
            }
        }
    }
    public float getCalibre() {
        return calibre;
    }
    public String getDureza() {
        return dureza;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(calibre) + ":" + dureza + ":" + size;
    }

}
