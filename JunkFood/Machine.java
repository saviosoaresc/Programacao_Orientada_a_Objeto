package JunkFood;
import java.util.ArrayList;
import java.util.List;

public class Machine {
    private final List<Slot> espirais;
    private double saldo;

    public Machine(int qtd) {
        espirais = new ArrayList<>();
        for(int i=0; i<qtd; i++){
         espirais.add(new Slot("empty", 0, 0f));
        }
    }

    public void setSlot(int index, String nome, int qtd, double value) {
        if (!validarIndex(index))
            return;
        espirais.set(index, new Slot(nome, qtd, value));
    }

    public boolean validarIndex(int index) {
        if (index < espirais.size() && index >= 0)
            return true;
        System.out.println("fail: indice nao existe");
        return false;
    }

    public void dinheiro(double value) {
        saldo += value;
    }

    public double pegarTroco() {
        double troco = saldo;
        saldo = 0;
        return troco;
    }

    public void limpar(int index) {
        if (!validarIndex(index))
            return;
        espirais.set(index, new Slot());
    }

    public void comprar(int index) {
        if (!validarIndex(index))
            return;
        if (espirais.get(index).getQtd() == 0) {
            System.out.println("fail: espiral sem produtos");
            return;
        }
        if (espirais.get(index).getPrice() > saldo) {
            System.out.println("fail: saldo insuficiente");
            return;
        }
        saldo -= espirais.get(index).getPrice();
        espirais.get(index).setQtd(espirais.get(index).getQtd() - 1);
        System.out.println("voce comprou um " + espirais.get(index).getName());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("saldo: %.2f%n", saldo));
        for (int i = 0; i < espirais.size(); i++) {
            Slot slot = espirais.get(i);
            result.append(String.format("%d %s%n", i, slot.toString()));
        }
        return result.toString();
    }
}

