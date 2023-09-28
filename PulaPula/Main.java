package PulaPula;

import java.util.Scanner;

public class Main {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        Trampoline trampolim = new Trampoline();
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$"+ line);
            String[] args = line.split(" ");
            if(args[0].equals("end")) {
                break;
            } else if(args[0].equals("arrive")) { // name age
                trampolim.arrive(new Kid(args[1], Integer.parseInt(args[2]))) ;
            } else if(args[0].equals("enter")) {
                trampolim.enter();
            } else if(args[0].equals("leave")) {
                trampolim.leave();
            } else if(args[0].equals("remove")) {//name
                trampolim.removeKid(args[1]);
            } else if(args[0].equals("show")) {
//                trampolim.toString();
                System.out.println(trampolim);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
