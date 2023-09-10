package Lapiseira;

import java.util.Scanner;

public class Main {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        Pencil lapiseira = new Pencil(0.5f);
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String args[] = line.split(" ");
            if(args[0].equals("end")) {
                break;
            } else if(args[0].equals("help")) {
                System.out.println("init _calibre; insert _calibre _dureza _tamanho; remove; writePage _folhas");
            } else if(args[0].equals("init")) { //calibre
                lapiseira = new Pencil(Float.parseFloat(args[1]));
            } else if(args[0].equals("insert")) {//calibre dureza size
                float calibre = Float.parseFloat(args[1]);
                String dureza  = args[2];
                int size = Integer.parseInt(args[3]);
                lapiseira.insert(new Lead(calibre, dureza, size));
            } else if(args[0].equals("remove")) {
                lapiseira.remove();
            } else if(args[0].equals("show")) {
                System.out.println(lapiseira);
            } else if (args[0].equals("write")) {
                lapiseira.writePage();
            } else if (args[0].equals("pull")) {
                lapiseira.pull();
            }  else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
