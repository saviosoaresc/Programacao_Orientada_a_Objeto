package Cofre;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pig {
    ArrayList<Item> itens = new ArrayList<>();
    ArrayList<Coin> coins = new ArrayList<>();
      

    int volume, volumeMax;
    boolean broken = false;
    private double value;
    String state = "intact";

    public Pig(int volumeMax) {
        this.volumeMax = volumeMax;
    }
    
    boolean addCoin(Coin coin) {
        int verif = this.volume + coin.volume;
        if(verif > this.volumeMax){
            System.out.println("fail: the pig is full");
            return false;
        }else{
            if("broken".equals(state)){
                System.out.println("fail: the pig is broken");
                return false;
            }else{
                coins.add(coin);
                this.volume += coin.volume;
                this.value += coin.value;
                return true;            
            }            
        }
    }

    boolean addItem(Item item) {
        int verif = this.volume + item.volume;
        if(verif > this.volumeMax){
            System.out.println("fail: the pig is full");
            return false;
        }else{
            if("broken".equals(state)){
                System.out.println("fail: the pig is broken");
                return false;
            }else{
                itens.add(item);
                this.volume += item.volume;
                return true;            
            }            
        }
    }


    boolean breakPig() {
        state = "broken";
        this.volume = 0;
        return broken = false; 
    }

    ArrayList<Coin> extractCoins() {
        ArrayList<Coin> coinsV = coins;
        if("intact".equals(state)){
            System.out.println("fail: you must break the pig first");
            System.out.println(new ArrayList<>());
            return new ArrayList<>();
        }else{
            coins = new ArrayList<>();
            System.out.println(coinsV);
            this.value = 0;
            return coinsV;             
        }
    }

    ArrayList<Item> extractItems() { 
        ArrayList<Item> itemV = itens;
        if("intact".equals(state)){
            System.out.println("fail: you must break the pig first");
            System.out.println(new ArrayList<>());
            return new ArrayList<>();
        }else {
            itens = new ArrayList<>();
            System.out.println(itemV);
            return itemV;              
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    
    //state=intact : coins=[0.10:1, 0.50:3] : items=[ouro:3, passaporte:2] : value=0.60 : volume=9/20
    @Override
    public String toString(){
        if(broken == true){
            state = "broken";
        }
        DecimalFormat form = new DecimalFormat("0.00");
//        return "display = " + form.format(this.display).replace(",", ".") + ", battery = " + this.battery;
        String ss = "";
        ss +=  "state=" + state + " : "
            +  "coins=" + coins.toString() + " : "
            +  "items=" + itens.toString() + " : "
            +  "value=" + form.format(value).replace(",", ".") + " : "
            + "volume="  + volume + "/" + volumeMax;
        return ss;
    }

};

