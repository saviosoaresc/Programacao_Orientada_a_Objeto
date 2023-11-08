package Agiota;

import java.util.*;

public class Client {
    private String name;
    private int limite;
    ArrayList<Operation> operations;

    public Client(String name, int limite) {
        operations = new ArrayList<>();
        this.name = name;
        this.limite = limite;
    }

    public Client() {
    }
    
    public String getName() {
        return name;
    }
    public int getLimite() {
        return limite;
    }
    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }
    
    public int getBalance() {
        int balance = 0;
        for(Operation opera : operations){
            if(null != opera.getLabel())switch (opera.getLabel()) {
                case give:
                    balance += opera.getValue();
                    break;
                case take:
                    balance -= opera.getValue();
                    break;
                case plus:
                    balance += opera.getValue();
                    break;
                default:
                    break;
            }
        }
        return balance;
    }
    
    @Override
    public String toString() {
        return ":) " + name + " " + getBalance() + "/" + limite + "\n";
    }
    public String saidaDeath(){
        return ":( " + name + " " + getBalance() + "/" + limite + "\n"; 
    }
}