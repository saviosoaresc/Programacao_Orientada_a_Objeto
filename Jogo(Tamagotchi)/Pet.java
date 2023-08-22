/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author savio
 */
class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds;
    private int age;
    private boolean alive;

    public Pet(int energy, int hungry, int clean){
        this.energy = energy;
        this.energyMax = energy;
        this.hungry = hungry;
        this.hungryMax = hungry;
        this.clean = clean;
        this.cleanMax = clean;
        this.alive = true;
    }

    void setEnergy(int value){
        if(value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
            return;
        } 
        if(value > this.energyMax) {
            this.energy = this.energyMax;
            return;
        }
        this.energy = value;
    }


    public void setHungry(int value){
        if(value <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
            return;
        } 
        if(value > this.hungryMax) {
            this.hungry = this.hungryMax;
            return;
        }
        this.hungry = value;
    }
    
    void setClean(int value){
        if(value <= 0){
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
            return;
        } 
        if(value > this.cleanMax) {
            this.clean = this.cleanMax;
            return;
        }
        this.clean = value;
    }

    private boolean testAlive(){
        if (!this.alive){
            System.out.println("fail: pet esta morto");
        }
        return this.alive;
    }


    @Override
    public String toString(){
        String ss = "";
        ss +=  "E:" + energy + "/" + energyMax + ", "
            +  "S:" + hungry + "/" + hungryMax + ", "
            +  "L:" + clean + "/" + cleanMax + ", "
            +  "D:" + diamonds + ", " + "I:"  + age;
        return ss;
    }

    public void play(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() - 1);
        setClean(getClean() - 3);
        diamonds += 1;
        age += 1;
    }
    public void shower(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 3);
        setHungry(getHungry() - 1);
        setClean(getCleanMax());
        diamonds += 0;
        age += 2;
    }

    public void eat(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 4);
        setClean(getClean() - 2);
        diamonds += 0;
        age += 1;
    }

    public void sleep(){
        int diferenca = this.energyMax - this.energy;
        if(diferenca >= 5){
            if(!testAlive())
            return;
        
        
        setEnergy(getEnergyMax());
        setHungry(getHungry() - 1);
//        setClean(getClean() - 2);
//        diamonds += 0;
        age += diferenca;
        }else System.out.println("fail: nao esta com sono");
    }


    int getClean(){
        return clean;
    }
    int getHungry(){
        return hungry;
    }
    int getEnergy(){
        return energy;
    }
    int getEnergyMax(){
        return energyMax;
    }
    int getCleanMax(){
        return cleanMax;
    }
    int getHungryMax(){
        return hungryMax;
    }
}
