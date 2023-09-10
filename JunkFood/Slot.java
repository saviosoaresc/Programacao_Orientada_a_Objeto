package JunkFood;

public class Slot {
    private String name;
    private double price;
    private int qtd;

    public Slot(String name, double price, int qtd) {
        this.name = name;
        this.price = price;
        this.qtd = qtd;
    }

    public Slot() {
        this("empty", 0.0, 0);
    }

    public int getQtd() {
        return this.qtd;
    }

    public double getPrice() {
        return this.price;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("[ %8s : %2d U : %.2f RS]", name, qtd, price);
    }
}

