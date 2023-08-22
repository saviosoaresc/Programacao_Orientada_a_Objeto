import java.util.Scanner;

class Ponto {
    float x;
    float y;
    
    void ler() {
        String linha = input();                 //lendo uma string e botando em linha
        String v[] = linha.split(" ");     //separa por um espaço em branco e põe num vetor separando-os
        x = Float.parseFloat( v[0] );           //transforma o vetor em float e bota dentro de x
        y = Float.parseFloat( v[1] );           //transforma o vetor em float e bota dentro de y
    }
    
    float distancia( Ponto ponto ) {
        float cH = this.x - ponto.x;                        //não entendi a diferença dos "x"
        float cV = this.y - ponto.y;                        //não entendi a diferenla dos "y"
        float dist = (float) Math.sqrt( cH*cH + cV*cV );
        return dist;
    }
    
//    boolean estaDentro( Circulo circ ) {
//        if ( this.distancia( circ.centro ) <= circ.raio ) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    String input() { return QuantosDentro.in.nextLine(); }
}

class Circulo {
    Ponto centro;
    float raio;

    void ler() {
        String linha = input();
        String v[] = linha.split(" ");
        centro = new Ponto();
        centro.x = Float.parseFloat( v[0] );
        centro.y = Float.parseFloat( v[1] );
        raio = Float.parseFloat( v[2] );
    }
    
    boolean contem( Ponto ponto ) {
        return this.centro.distancia( ponto ) <= this.raio;
    }

    int quantosDentro( Ponto[] vetor ) {
        int cont = 0;
        for ( Ponto ponto : vetor ) {
            if ( this.contem( ponto ) ) cont++;
        }
        return cont;
    }

    String input() { return QuantosDentro.in.nextLine(); }
}

class QuantosDentro {
    public static void main(String[] arg) {
        int n = Integer.parseInt( input() );
        Ponto vetor[] = new Ponto[n];
        for (int i=0; i<vetor.length; i++) {
            vetor[i] = new Ponto();
            vetor[i].ler();
        }
        Circulo circ = new Circulo();
        circ.ler();
        
        int cont = circ.quantosDentro( vetor );
        System.out.printf( "%d", cont );
    }

    static Scanner in = new Scanner(System.in);
    static String input() { return in.nextLine(); }
}