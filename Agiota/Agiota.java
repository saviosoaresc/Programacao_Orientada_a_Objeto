package Agiota;

import java.util.*;

public class Agiota {

    private final ArrayList<Client> aliveCli; // Lista viva
    private final ArrayList<Client> deathCli; // Lista morta
    private final ArrayList<Operation> aliveOper; // Operacao viva
    private final ArrayList<Operation> deathOper; // Operacao morta

    //inicializa todas as Lists
    public Agiota() {
        aliveCli = new ArrayList<>();
        aliveOper = new ArrayList<>();
        deathCli = new ArrayList<>();
        deathOper = new ArrayList<>();
    }

    //Funcoa que adicona o cliente por meio do nome e do litime dele
    public void addClient(String name, int limite) {
        //percorre a lista de clientes vivos e se ja existir retorana um erro
        for (int i = 0; i < aliveCli.size(); i++) {
            if (name.equals(aliveCli.get(i).getName())) {
                System.out.println("fail: cliente ja existe");
                return;
            }
        }
        //se sair da lista vivo e nao retorna para a funcao, adiciona o cliente
        aliveCli.add(new Client(name, limite));
    } // ✅✅✅✅✅✅

    //Funcao que dar uma operacao para o nome que eh passado pelo usuario
    public void give(String name, int value) {
        //percore a list de clientes vivos
        for (int i = 0; i < aliveCli.size(); i++) {
            //se o nome que passar estiver na list de vivos
            if (name.equals(aliveCli.get(i).getName())) {
                //se o valor que o user passar somando a balanca dele passar do limite, retorna um erro 
                if (value + aliveCli.get(i).getBalance() > aliveCli.get(i).getLimite()) {
                    System.out.println("fail: limite excedido");
                    return;
                } else {
                    //se nenhum erro acima acontecer, adiciono a operacao na list de clientes vivos e nas operacao vivas
                    Operation opera = new Operation(name, Label.give, value);
                    aliveCli.get(i).getOperations().add(opera);
                    aliveOper.add(opera);
                    return;
                }
            }
        }
        System.out.println("fail: cliente nao existe");
    } // ✅✅✅✅✅✅✅✅✅

    public void take(String name, int value) {
        for (int i = 0; i < aliveCli.size(); i++) {
            if (name.equals(aliveCli.get(i).getName())) {
                Operation opera = new Operation(name, Label.take, value);
                aliveCli.get(i).getOperations().add(opera);
                aliveOper.add(opera);
                return;
            }
        }
        System.out.println("fail: cliente nao existe");
    } // ✅✅✅✅✅✅✅✅✅

    public String searchClient(String name) {
        String saida = "";
        for (int i = 0; i < aliveCli.size(); i++) {
            if (name.equals(aliveCli.get(i).getName())) {
                saida += aliveCli.get(i).getName() + " "
                        + aliveCli.get(i).getBalance() + "/"
                        + aliveCli.get(i).getLimite() + "\n";
            }
        }
        for (int i = 0; i < aliveOper.size(); i++) {
            if (name.equals(aliveOper.get(i).getName())) {
                saida += "id:" + i + " "
                        + aliveOper.get(i).getLabel() + ":"
                        + aliveOper.get(i).getName() + " "
                        + aliveOper.get(i).getValue() + "\n";
            }
        }
        return saida;
    } // ✅✅✅✅✅✅✅✅✅✅

    public void kill(String name) {
//        for (int i = 0; i < aliveCli.size(); i++) {
//            if (name.equals(aliveCli.get(i).getName())) {
//                deathCli.add(aliveCli.remove(i));
//            }
//        }
        for (Client client : aliveCli) {
            if (name.equals(client.getName())) {
                deathCli.add(client);
            }
        }
        for(Operation opera : aliveOper){
            if (name.equals(opera.getName())) {
                deathOper.add(opera);
            }
        }
        
        for (Client client : aliveCli) {
            if (name.equals(client.getName())) {
                aliveCli.remove(client);
            }
        }
        for(Operation opera : aliveOper){
            if (name.equals(opera.getName())) {
                aliveOper.remove(opera);
            }
        }
        
        
//        for (int i = 0; i < aliveOper.size(); i++) {
//            if (name.equals(aliveOper.get(i).getName())) {
//                deathOper.add(aliveOper.remove(i));
//                aliveCli.get(i).operations.remove(i);
//            }
//        }
    }

//    private int resultPorc(int valor) {
//        int result = (int) Math.ceil(valor * 0.1);
//        return result;
//    }
    public void plus() {
        for (int i = 0; i < aliveCli.size(); i++) {
            int result = (int) Math.ceil(aliveCli.get(i).getBalance() * 0.1);
            Operation opera = new Operation(aliveCli.get(i).getName(), Label.plus, result);
            aliveCli.get(i).getOperations().add(opera);
            aliveOper.add(opera);
            if (aliveCli.get(i).getBalance() > aliveCli.get(i).getLimite()) {
//            Operation opera = new Operation(aliveCli.get(i).getName(), Label.plus, resultPorc(aliveCli.get(i).getBalance()));
                kill(aliveCli.get(i).getName());
            }
        }
    }

    @Override
    public String toString() {
        String saida = "";
//===================== ALIVE ==================================
        aliveCli.sort(Comparator.comparing(Client::getName));
        for (int i = 0; i < aliveCli.size(); i++) {
            saida += aliveCli.get(i);
        }
        for (int i = 0; i < aliveOper.size(); i++) {
            saida += aliveOper.get(i);
        }

//===================== DEATH ==================================
        if (!deathCli.isEmpty()) {
            for (int i = 0; i < deathCli.size(); i++) {
                saida += deathCli.get(i).saidaDeath();
            }
            for (int i = 0; i < deathOper.size(); i++) {
                saida += deathOper.get(i).saidaDeath();
            }
        }
        return saida;
    }

    private void sortAliveList() {
        this.aliveCli.sort((Client c1, Client c2) -> c1.getName().compareTo(c2.getName()));
//        this.aliveCli.sort( new Comparator<Client>() {
//            public int compare(Client c1, Client c2) {
//                return c1.getName().compareTo(c2.getName());
//            }
//        });

    }
}
