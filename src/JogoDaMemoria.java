import java.util.Scanner;
import java.util.Random;
public class JogoDaMemoria {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int TAMANHO =7;
        int TOTAL_PARES = 24;

        int placarJogador1 = 0;
        int placarJogador2 = 0;
        int jogadorAtual = 1;
        int paresEncontrtados = 0;


        char [][] tabuleiro = new char [TAMANHO][TAMANHO];
        char [][] cartas = new char [TAMANHO][TAMANHO];
        char [][] reveladas = new char [TAMANHO][TAMANHO];


        for(int i=0; i < TAMANHO;i++){
            for(int j=0;j< TAMANHO; j++){
                cartas[i][j] = ' ';
                reveladas[i][j] = 0;
                tabuleiro[i][j] = '#';
            }
        }

        for(char letra ='A';letra <='X'; letra++){
            int linha1, coluna1;
            do{
                linha1 = random.nextInt(TAMANHO);
                coluna1 = random.nextInt(TAMANHO);
            } while (cartas[linha1][coluna1] != ' ');
            cartas[linha1][coluna1] = letra;

            int linha2, coluna2;
            do {
                linha2 = random.nextInt(TAMANHO);
                coluna2 = random.nextInt(TAMANHO);
            } while (cartas[linha2][coluna2] != ' ');
            cartas[linha2][coluna2] = letra;
        }
        //MOSTRANDO GABARITO PROF
        for(int i =0;i<cartas.length;i++){
            System.out.println();
            for(int j=0;j<cartas.length;j++){
                System.out.print(" "+cartas[i][j]);
            }
        }
        System.out.println("\n------->JOGO DA MEMORIA<-------");

        

    }
}
