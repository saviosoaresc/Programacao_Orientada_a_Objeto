import java.util.Scanner;

class Aluno{
    String nome;
    float notas[] = new float[3];
    float media;
    
    void leitura(){
        Scanner read = new Scanner(System.in);
        nome = read.nextLine();
        notas[0] = Float.parseFloat(read.nextLine());
        notas[1] = Float.parseFloat(read.nextLine());
        notas[2] = Float.parseFloat(read.nextLine());
    }
    
    void imprimirMedia(){
        media = (notas[0] + notas[1] + notas[2])/3;
        System.out.printf("%.1f", media);
    }
}

class NovaMedia{
    public static void main(String[] arg){
        Aluno aluno = new Aluno();
        aluno.leitura();
        aluno.imprimirMedia();
    }
}