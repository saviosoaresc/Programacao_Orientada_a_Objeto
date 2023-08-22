import java.util.Scanner;

class Aluno{
    String nome;
    int matric;
    String disc;
    float nota;
    
    void ler(){
        Scanner read = new Scanner(System.in);
        nome = read.nextLine();
        matric = Integer.parseInt(read.nextLine());
        disc = read.nextLine(); 
        nota = Float.parseFloat(read.nextLine());
    }
    
    void imprimir(){
        System.out.println("Nome = " + nome);
        System.out.println("Matricula = " + matric);
        System.out.println("Disciplina = " + disc);
        System.out.println("Nota = " + nota);
    }
}


class Impressao{
    public static void main(String[] arg){
        Aluno aluno = new Aluno();
        aluno.ler();
        aluno.imprimir();
    } 
}






