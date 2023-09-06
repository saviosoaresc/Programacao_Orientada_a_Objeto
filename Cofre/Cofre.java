package Cofre;

import java.util.*;

public class Cofre {
    public static void main(String[] a) {
        Pig pig = new Pig(0);
//        Item item = new Item("", 0);
//        Coin coin = new Coin("", 0.00, 0);
        while (true) {
                var line = input();
                write("$" + line);
                var args = line.split(" ");

                if      (args[0].equals("end")) { break; } //FEITO


                else if (args[0].equals("addCoin")) { 
                    if (args[1].equals("10"))pig.addCoin(new Coin("10", 0.10, 1));
                    else if (args[1].equals("25"))pig.addCoin(new Coin("25", 0.25, 2));
                    else if (args[1].equals("50")) pig.addCoin(new Coin("50", 0.50, 3));
                    else if (args[1].equals("100"))pig.addCoin(new Coin("100", 1.00, 4));
                    else{ write("fail: invalid money"); }
                }

                else if (args[0].equals("init")) { pig = new Pig( (int)number(args[1]) );} //FEITO
                else if (args[0].equals("addItem")) { pig.addItem(new Item(args[1], Integer.parseInt(args[2])) ); }
                else if (args[0].equals("break")) { pig.breakPig();} //FEITO
                else if (args[0].equals("extractCoins")) { pig.extractCoins();}
                else if (args[0].equals("extractItems")) {pig.extractItems();}
                else if (args[0].equals("show")) { write(pig.toString());} //FEITO
                else { write("fail: invalid command");} //FEITO
        }
    }
    private static final Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}