package SuperMercado;
import java.util.Scanner;
public class Main {
    public static void main(String a[]) {
        Mercantil mercantil = new Mercantil(0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] args = line.split(" ");
            System.out.println("$" + line);

            if (args[0].equals("end")) {
                break;
            } else if (args[0].equals("init")) {
                mercantil = new Mercantil(Integer.parseInt(args[1]));
            } else if (args[0].equals("call")) {
                mercantil.chamarNoCaixa(Integer.parseInt(args[1]));
            } else if (args[0].equals("finish")) {
                mercantil.finalizar(Integer.parseInt(args[1]));
            } else if (args[0].equals("arrive")) {
                mercantil.chegar(new Person(args[1]));
            } else if (args[0].equals("show")) {
                System.out.println(mercantil);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}
