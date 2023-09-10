package Cinema;

import java.util.LinkedList;

public class Sala {
    private LinkedList<Cliente> cadeiras;
    int capacidade;


    public Sala(int capacidade) {
        this.capacidade = capacidade;
        cadeiras = new LinkedList<>();
        for(int i = 0; i < capacidade; i++) {
            cadeiras.add(new Cliente("-", ""));
        }
    }

    public LinkedList<Cliente> getCadeiras() {
        return cadeiras;
    }
    
    public boolean reservar(String id, String fone, int indice) {
        for (int i = 0; i < cadeiras.size(); i++) {
            if(cadeiras.get(i).getId().equals(id)){
                System.out.println("fail: cliente ja esta no cinema");
                return false;
            }
        }
        
        if(indice >= capacidade){
            System.out.println("fail: cadeira nao existe");
            return false;
        }else{
            if(cadeiras.get(indice).getId().equals("-")){
                Cliente cliente = new Cliente(id, fone);
                cadeiras.set(indice, cliente);
                return true;
            }else{
                System.out.println("fail: cadeira ja esta ocupada");
                return false;            
            }            
        }
        
        
        
    }

    public void cancelar(String id) {
        for (int i = 0; i < cadeiras.size(); i++) {
            if(cadeiras.get(i).getId().equals(id)){
                cadeiras.set(i, new Cliente("-", ""));
                return;
            }
        }
        System.out.println("fail: cliente nao esta no cinema");
    }

    @Override
    public String toString() {
        String saida = "[";
        for(int i=0; i < cadeiras.size(); i++){
            saida += cadeiras.get(i) + (i == cadeiras.size() - 1 ? "" : " ");
        }
        return saida + "]";
    }
}
