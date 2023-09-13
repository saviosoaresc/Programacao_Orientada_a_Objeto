package Contato;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contact contato = new Contact();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] command = line.split(" ");

            if (command[0].equals("end")) {
                break;
            } else if (command[0].equals("init")) { // name
                contato = new Contact(command[1]);
            } else if (command[0].equals("add")) {
                    contato.addFone(command[1], command[2]);
            } else if (command[0].equals("rm")) {
                    contato.rmFone(Integer.parseInt(command[1]));
            } else if (command[0].equals("tfav")) {
                    contato.toggleFavorited();
            } else if (command[0].equals("show")) {
                    System.out.println(contato);
            } else {
                System.out.println("fail: Comando inválido");
            }
        }
        
        scanner.close();
    }
}
