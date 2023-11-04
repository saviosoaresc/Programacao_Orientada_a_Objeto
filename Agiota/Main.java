package Agiota;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
//        println("side_by_side=080");
        Agiota agiota = new Agiota();
        try{
            while (true) {
                String line = input();
                println("$" + line);
                String[] args = line.split(" ");

                if      (args[0].equals("end"))     { break; }
                else if (args[0].equals("addCli"))  { agiota.addClient( args[1], (int) number(args[2]) ); }
                else if (args[0].equals("init"))    { agiota = new Agiota(); }
                else if (args[0].equals("show"))    { print(agiota); }
                else if (args[0].equals("showCli")) { print( agiota.searchClient( args[1] ) ); }
                else if (args[0].equals("give"))    { agiota.give( args[1], (int) number(args[2]) ); }
                else if (args[0].equals("take"))    { agiota.take( args[1], (int) number(args[2]) ); }
//                else if (args[0].equals("kill"))    { agiota.kill( args[1] ); }
//                else if (args[0].equals("plus"))    { agiota.plus(); }
                else                                { println("fail: comando invalido"); }
            }
        } catch(Exception e){
            println(e.getMessage());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }

    }
