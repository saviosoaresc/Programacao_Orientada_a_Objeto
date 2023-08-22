package jogo;

import java.util.*;

public class Tamagochi {
    public static void main(String[] a) {
        Pet pet = new Pet(0, 0, 0);
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break; }
            else if (args[0].equals("show"))  { write(pet.toString()); }
            else if (args[0].equals("init"))  { pet = new Pet((int)number(args[1]), (int)number(args[2]), (int)number(args[3])); }
            else if (args[0].equals("play"))  { pet.play(); }
            else if (args[0].equals("eat"))   { pet.eat(); }
            else if (args[0].equals("sleep")) { pet.sleep(); }
            else if (args[0].equals("shower")){ pet.shower(); }
            else  { write("fail: comando invalido"); }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
