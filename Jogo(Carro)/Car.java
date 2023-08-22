public class Car {
    private int pass = 0;
    private int passMax = 2;
    private int gas = 0;
    private int gasMax = 100;
    private int km = 0;


    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getPassMax() {
        return passMax;
    }

    public void setPassMax(int passMax) {
        this.passMax = passMax;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getGasMax() {
        return gasMax;
    }

    public void setGasMax(int gasMax) {
        this.gasMax = gasMax;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }


    public void addPass() {
        if(getPass() < getPassMax()){
            int addpass = getPass() + 1;
            setPass(addpass);            
//            System.out.println("pass: " + getPass() + ", gas: " + getGas() + ", km: " + getKm());
        }else System.out.println("fail: limite de pessoas atingido");
    }
    
    public void removePass(){
        if(getPass() > 0){
            int removepass = getPass() - 1;
            setPass(removepass);
//            System.out.println("pass: " + getPass() + ", gas: " + getGas() + ", km: " + getKm());
        }else System.out.println("fail: nao ha ninguem no carro");
    }
    
    public void drive(int valorKm){
        
        if(getPass() == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }else if(getGas() == 0){
            System.out.println("fail: tanque vazio");
        }else if(valorKm > getGas()){
            int diferenca = valorKm - getGas();
            int kmDrive = valorKm - diferenca;
            int kmFinal = kmDrive + getKm();
            setKm(kmFinal);
            System.out.println("fail: tanque vazio apos andar " + kmDrive + " km");
            setGas(0);
        }else {
            int addKm = getKm() + valorKm;
            setKm(addKm);
            int removeGas = getGas() - valorKm;
            setGas(removeGas);
        }        
    }
    
    public void fuel(int valorGas){
        if(valorGas >= getGasMax()){
            setGas(getGasMax());
        }else {
            int addgas = valorGas;
            setGas(addgas);            
        }
    }
    
    @Override
    public String toString() {
        return "pass: " + pass + ", gas: " + gas + ", km: " + km;
    }
}
