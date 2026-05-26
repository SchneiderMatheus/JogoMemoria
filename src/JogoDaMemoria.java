import java.util.Scanner;
import java.util.Random;

public class JogoDaMemoria {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int TAMANHO = 7;
        int TOTAL_PARES = 24;

        int placarJogador1 = 0;
        int placarJogador2 = 0;
        int paresEncontrados = 0;
        boolean turno = true;

        char[][] tabuleiro = new char[TAMANHO][TAMANHO];
        char[][] cartas = new char[TAMANHO][TAMANHO];
        int[][] reveladas = new int[TAMANHO][TAMANHO];

        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                cartas[i][j] = ' ';
                reveladas[i][j] = 0;
                tabuleiro[i][j] = '#';
            }
        }

        for (char letra = 'A'; letra <= 'X'; letra++) {
            int linha1, coluna1;
            do {
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

        int coringaL, coringaC;

        do {
            coringaL = random.nextInt(TAMANHO);
            coringaC = random.nextInt(TAMANHO);
        } while (cartas[coringaL][coringaC] != ' ');
        cartas[coringaL][coringaC] = '*';

        // MOSTRANDO GABARITO PROF
        for (int i = 0; i < cartas.length; i++) {
            System.out.println();
            for (int j = 0; j < cartas.length; j++) {
                System.out.print(" " + cartas[i][j]);
            }
        }
        System.out.println();
        System.out.println("\n------->JOGO DA MEMORIA<-------");

        while (paresEncontrados < TOTAL_PARES) {

            int linha1 = 0;
            int coluna1 = 0;
            int linha2 = 0;
            int coluna2 = 0;

            System.out.println("\n--- TABULEIRO ATUAL ---");
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    if (reveladas[i][j] == 1) {
                        System.out.print(" " + cartas[i][j]);
                    } else {
                        System.out.print(" " + tabuleiro[i][j]);
                    }
                }
                System.out.println();
            }

            if (turno == true) {
                boolean entradaValida = false;

                while (!entradaValida) {
                    System.out.println("Jogador 1: escolha a linha entre 1 e 7");
                    linha1 = sc.nextInt() - 1;
                    System.out.println("Jogador 1: escolha a coluna entre 1 e 7 ");
                    coluna1 = sc.nextInt() - 1;
                    System.out.println("Coordenada " + (linha1 + 1) + "x" + (coluna1 + 1));

                    if (linha1 < 0 || linha1 >= 7 || coluna1 < 0 || coluna1 >= 7) {
                        System.out.println("Coordenada inválida! Use valores entre 1 e 7.");

                    } else if (reveladas[linha1][coluna1] == 1) {
                        System.out.println("Esta carta já foi revelada! Escolha outra.");
                    } else {
                        entradaValida = true;
                    }
                }

                tabuleiro[linha1][coluna1] = cartas[linha1][coluna1];
                reveladas[linha1][coluna1] = 1;

                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro.length; j++) {
                        if (reveladas[i][j] == 1) {
                            System.out.print(" " + cartas[i][j]);
                        } else {
                            System.out.print(" " + tabuleiro[i][j]);
                        }
                    }
                    System.out.println();
                }

                if (cartas[linha1][coluna1] == '*') {
                    reveladas[linha1][coluna1] = 1;
                    tabuleiro[linha1][coluna1] = '*';

                    for (int i = 0; i < tabuleiro.length; i++) {
                        System.out.println();
                        for (int j = 0; j < tabuleiro.length; j++) {
                            System.out.print(" " + tabuleiro[i][j]);

                        }
                    }

                    System.out.println("\nSeu turno acabou");
                    turno = false;
                    continue;
                }

                boolean entradaValida2 = false;
                while (!entradaValida2) {
                    System.out.println("Jogador 1 escolha a segunda carta: linha entre 1 e 7");
                    linha2 = sc.nextInt() - 1;
                    System.out.println("Jogador 1 escolha a segunda carta:coluna entre 1 e 7 ");
                    coluna2 = sc.nextInt() - 1;
                    System.out.println("Coordenada " + (linha2 + 1) + "x" + (coluna2 + 1));

                    if (linha2 < 0 || linha2 >= 7 || coluna2 < 0 || coluna2 >= 7) {
                        System.out.println("Coordenada inválida! Use valores entre 1 e 7.");

                    } else if (reveladas[linha2][coluna2] == 1) {
                        System.out.println("Esta carta já foi revelada! Escolha outra.");
                    } else {
                        entradaValida2 = true;
                    }
                }

                tabuleiro[linha2][coluna2] = cartas[linha2][coluna2];
                reveladas[linha2][coluna2] = 1;

                for (int i = 0; i < tabuleiro.length; i++) {
                    System.out.println();
                    for (int j = 0; j < tabuleiro.length; j++) {
                        System.out.print(" " + tabuleiro[i][j]);

                    }
                }

                if (cartas[linha1][coluna1] == cartas[linha2][coluna2]) {
                    System.out.println("\nPar encontrado!");
                    placarJogador1++;
                    paresEncontrados++;

                    System.out.println();
                    System.out.println("Voce joga de novo");
                    System.out.println("Pressione ENTER para continuar");

                    sc.nextLine();
                    sc.nextLine();
                } else {
                    System.out.println("\nErrouuu! As cartas não combinam.");

                    tabuleiro[linha1][coluna1] = '#';
                    tabuleiro[linha2][coluna2] = '#';
                    reveladas[linha1][coluna1] = 0;
                    reveladas[linha2][coluna2] = 0;
                    if (cartas[linha2][coluna2] == '*') {
                        tabuleiro[linha2][coluna2] = '*';
                        reveladas[linha2][coluna2] = 1;
                    }

                    System.out.println("\n\nPressione ENTER para passar");
                    sc.nextLine();
                    sc.nextLine();
                    turno = false;
                }

            } else {
                boolean entradaValida = false;

                while (!entradaValida) {
                    System.out.println("Jogador 2: escolha a linha entre 1 e 7");
                    linha1 = sc.nextInt() - 1;
                    System.out.println("Jogador 2: escolha a coluna entre 1 e 7 ");
                    coluna1 = sc.nextInt() - 1;
                    System.out.println("Coordenada " + (linha1 + 1) + "x" + (coluna1 + 1));

                    if (linha1 < 0 || linha1 >= 7 || coluna1 < 0 || coluna1 >= 7) {
                        System.out.println("Coordenada inválida! Use valores entre 1 e 7.");

                    } else if (reveladas[linha1][coluna1] == 1) {
                        System.out.println("Esta carta já foi revelada! Escolha outra.");
                    } else {
                        entradaValida = true;
                    }
                }

                tabuleiro[linha1][coluna1] = cartas[linha1][coluna1];
                reveladas[linha1][coluna1] = 1;

                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro.length; j++) {
                        if (reveladas[i][j] == 1) {
                            System.out.print(" " + cartas[i][j]);
                        } else {
                            System.out.print(" " + tabuleiro[i][j]);
                        }
                    }
                    System.out.println();
                }

                if (cartas[linha1][coluna1] == '*') {
                    reveladas[linha1][coluna1] = 1;
                    tabuleiro[linha1][coluna1] = '*';

                    for (int i = 0; i < tabuleiro.length; i++) {
                        System.out.println();
                        for (int j = 0; j < tabuleiro.length; j++) {
                            System.out.print(" " + tabuleiro[i][j]);

                        }
                    }

                    System.out.println("\nSeu turno acabou");
                    turno = true;
                    continue;
                }

                boolean entradavalida2 = false;
                while (!entradavalida2) {
                    System.out.println("Jogador 2 escolha a segunda carta: linha entre 1 e 7");
                    linha2 = sc.nextInt() - 1;
                    System.out.println("Jogador 2 escolha a segunda carta:coluna entre 1 e 7 ");
                    coluna2 = sc.nextInt() - 1;
                    System.out.println("Coordenada " + (linha2 + 1) + "x" + (coluna2 + 1));

                    if (linha2 < 0 || linha2 >= 7 || coluna2 < 0 || coluna2 >= 7) {
                        System.out.println("Coordenada inválida! Use valores entre 1 e 7.");

                    } else if (reveladas[linha2][coluna2] == 1) {
                        System.out.println("Esta carta já foi revelada! Escolha outra.");
                    } else {
                        entradavalida2 = true;
                    }
                }

                tabuleiro[linha2][coluna2] = cartas[linha2][coluna2];
                reveladas[linha2][coluna2] = 1;

                for (int i = 0; i < tabuleiro.length; i++) {
                    System.out.println();
                    for (int j = 0; j < tabuleiro.length; j++) {
                        System.out.print(" " + tabuleiro[i][j]);

                    }
                }

                if (cartas[linha1][coluna1] == cartas[linha2][coluna2]) {
                    System.out.println("\nPar encontrado!");
                    placarJogador2++;
                    paresEncontrados++;

                    System.out.println();
                    System.out.println("Voce joga de novo");
                    System.out.println("Pressione ENTER para continuar");

                    sc.nextLine();
                    sc.nextLine();
                } else {
                    System.out.println("\nErrouuu! As cartas não combinam.");

                    tabuleiro[linha1][coluna1] = '#';
                    tabuleiro[linha2][coluna2] = '#';
                    reveladas[linha1][coluna1] = 0;
                    reveladas[linha2][coluna2] = 0;
                    if (cartas[linha2][coluna2] == '*') {
                        tabuleiro[linha2][coluna2] = '*';
                        reveladas[linha2][coluna2] = 1;
                    }

                    System.out.println("\n\nPressione ENTER para passar");
                    sc.nextLine();
                    sc.nextLine();
                    turno = true;
                }
            }

        }

        System.out.println("\nO Jogo Acabou");
        System.out.println("Placar final - jogador 1: " + placarJogador1);
        System.out.println("Placar final - jogador 2: " + placarJogador2);

        if (placarJogador1 > placarJogador2) {
            System.out.println("\nJOGADOR 1 É O VENCEDOR");
        } else if (placarJogador2 > placarJogador1) {
            System.out.println("\n JOGADOR 2 É O VENCEDOR");
        } else
            System.out.println("TEMOS UM EMPATE!");

        sc.close();
    }
}
