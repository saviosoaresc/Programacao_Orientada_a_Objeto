package MyClock;

public class Time {
    private int hour;
    private int minute;
    private int second;
    boolean hourV = true;
    boolean minuteV = true;
    boolean secondV = true;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setHour(int hour) {
        if(hour < 0 || hour > 23){
            System.out.println("fail: hora invalida");
            hourV = false;
        }else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if(minute < 0 || minute > 59){
            System.out.println("fail: minuto invalido");
            minuteV = false;
        }else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if(second < 0 || second > 59){
            System.out.println("fail: segundo invalido");
            secondV = false;
        }else {
            this.second = second;
        }
    }

    public void nextSecond() {
        second++;
        if(second > 59){
            second = 0;
            minute++;
        }
        if(minute > 59){
            minute = 0;
            hour++;
        }
        if(hour > 23){
            hour = 0;
        }
    }
    
    void verificacao(int hour, int minute, int second){
        setHour(hour);
        if(!hourV) this.hour = 0;
        setMinute(minute);
        if(!minuteV) this.minute = 0;
        setSecond(second);
        if(!secondV) this.second = 0;
    }
    
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
