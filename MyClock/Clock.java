package MyClock;

import java.util.*;

public class Clock {
    public static void main(String[] a) {   
        Time time = new Time(0, 0, 0);
        
        OUTER:
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");
            switch (args[0]) {
                case "end" -> {
                    break OUTER;
                }
                case "show" -> System.out.println(time.toString());
                case "next" -> time.nextSecond();
                case "set" -> {
                    time.setHour((int)number(args[1]));
                    time.setMinute((int)number(args[2]));
                    time.setSecond((int)number(args[3]));
                }
                case "init" -> time.verificacao((int) number(args[1]), (int)number(args[2]),(int)number(args[3]));
                default -> write("fail: comando invalido"); 
            }
        }
    }
    private static final Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
