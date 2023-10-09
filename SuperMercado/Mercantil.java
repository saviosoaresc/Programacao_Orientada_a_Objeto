package SuperMercado;

import java.util.ArrayList;
import java.util.LinkedList;

class Mercantil {
    private ArrayList<Person> caixas;
    private LinkedList<Person> esperando;

    public Mercantil(int qtdCaixas) {
        caixas = new ArrayList<>();
        for(int i = 0; i < qtdCaixas; i++) {
            caixas.add(new Person("-----"));
        }
        esperando = new LinkedList<>();
    }

    public void chegar(Person person) {
        esperando.add(person);
    }

    public void chamarNoCaixa(int indice) {
        Person person = caixas.get(indice);
        if (validarIndice(indice)) {
            if (!esperando.isEmpty()) {
                if("-----".equals(person.getNome())){
                    caixas.set(indice, esperando.get(0));
                    esperando.remove(0);                    
                }else System.out.println("fail: caixa ocupado");                    
            }else System.out.println("fail: sem clientes");
        }
    }

    public Person finalizar(int indice) {
        if (validarIndice(indice)) {
            Person person = caixas.get(indice);
            if(!"-----".equals(person.getNome())){
                caixas.set(indice, new Person("-----"));
                return person;
            }else System.out.println("fail: caixa vazio");            
        }else System.out.println("fail: caixa inexistente");
        return null;
    }

    private boolean validarIndice(int indice) {
        return indice >= 0 && indice < caixas.size();
    }

    @Override
    public String toString() {
        StringBuilder caixasStr = new StringBuilder("Caixas:");
        caixasStr.append(" ").append(caixas);
        return caixasStr.toString() + "\nEspera: " + esperando.toString();
    }
}
