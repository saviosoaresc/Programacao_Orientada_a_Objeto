package Cofre;

public class Item {
    String label;
    int volume;
    
    
    public Item(String label, int volume) {
        this.label = label;
        this.volume = volume;
    }   
    
    @Override
    public String toString(){
        String ss = "";
        ss += label + ":" + volume;
        return ss;
    }
    
    //    int getVolume(){ 
//        return volume; 
//    }
//    
//    String getLabel(){ 
//        return label; 
//    }
//    
//    void setVolume(int volume) { 
//        this.volume = volume;
//    }
//    
//    void setLabel(String label) { 
//        this.label = label;
//    } 
       
}