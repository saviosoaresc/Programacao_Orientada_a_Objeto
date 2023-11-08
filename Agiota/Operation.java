package Agiota;

public class Operation {

    private static int nextOpId = 0;
    private int id;
    private String name;
    private Label label;
    private int value;

    public Operation(String name, Label label, int value) {
        this.id = Operation.nextOpId++;
        this.name = name;
        this.label = label;
        this.value = value;
    }

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Label getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "+ id:" + id + " " + label + ":" + name + " " + value + "\n";
    }

    public String saidaDeath() {
        return "- id:" + id + " " + label + ":" + name + " " + value + "\n";
    }
}

enum Label {
    give, take, plus;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
