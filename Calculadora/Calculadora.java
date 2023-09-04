
import java.util.Scanner;

public class Calculadora {
    static Calculator calc = new Calculator(0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            String line = scanner.nextLine();
            String[] argsL = line.split(" ");
            write('$' + line);

            if      ("show".equals(argsL[0]))    { write(calc.toString());}
            else if ("init".equals(argsL[0]))    { calc = new Calculator(number(argsL[1]));}   
            else if ("charge".equals(argsL[0]))  { calc.chargeBattery(number(argsL[1]));}
            else if ("sum".equals(argsL[0]))     { calc.sum(number(argsL[1]), number(argsL[2]));}
            else if ("div".equals(argsL[0]))     { calc.division(number(argsL[1]), number(argsL[2]));}
            else if ("end".equals(argsL[0]))     { break;}
            else                                 { write("fail: comando invalido");}
        }
    }

    public static String input() { 
        Scanner scanner = new Scanner(System.in); 
        String input = scanner.nextLine(); 
//        scanner.close(); 
        return input; 
    }

    public static void write(String value) { System.out.println(value);                }
    public static int number(String str)   { return Integer.parseInt(str);             }
}