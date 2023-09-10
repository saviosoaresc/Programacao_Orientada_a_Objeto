package JunkFood;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine(0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] inputArgs = line.split(" ");
            System.out.println("$" + line);

            if (inputArgs[0].equals("end")) {
                break;
            } else if (inputArgs[0].equals("init")) {
                machine = new Machine(Integer.parseInt(inputArgs[1]));
            } else if (inputArgs[0].equals("show")) {
                System.out.println(machine.toString());
            } else if (inputArgs[0].equals("set")) {
                machine.setSlot(Integer.parseInt(inputArgs[1]), inputArgs[2], Integer.parseInt(inputArgs[3]), Integer.parseInt(inputArgs[4]));
            } else if (inputArgs[0].equals("limpar")) {
                machine.limpar(Integer.parseInt(inputArgs[1]));
            } else if (inputArgs[0].equals("dinheiro")) {
                machine.dinheiro(Double.parseDouble(inputArgs[1]));
            } else if (inputArgs[0].equals("comprar")) {
                machine.comprar(Integer.parseInt(inputArgs[1]));
            } else if (inputArgs[0].equals("troco")) {
                System.out.println(String.format("voce recebeu %.2f RS", machine.pegarTroco()));
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}