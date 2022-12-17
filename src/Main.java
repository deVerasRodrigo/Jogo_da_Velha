import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character[][] tabuleiro = new Character[3][3];
        Scanner scanner = new Scanner(System.in);

        JogoDaVelha.imprimirTabuleiro(tabuleiro);

        int jogadasRestantes = 9;

        while (!JogoDaVelha.checaVencedor(tabuleiro) && JogoDaVelha.verificaSeHaJogo(tabuleiro, jogadasRestantes, 'X')) {

            JogoDaVelha.jogadaDeX(tabuleiro, scanner);
            JogoDaVelha.imprimirTabuleiro(tabuleiro);
            jogadasRestantes--;

            if (JogoDaVelha.checaVencedor(tabuleiro)) {
                System.out.println("Jogador 01 Venceu!");
            } else if (!JogoDaVelha.verificaSeHaJogo(tabuleiro,jogadasRestantes, 'O')) {
                System.out.println("Deu Velha!");
            } else {
                JogoDaVelha.jogadaDeO(tabuleiro, scanner);
                JogoDaVelha.imprimirTabuleiro(tabuleiro);
                jogadasRestantes--;
                if (JogoDaVelha.checaVencedor(tabuleiro)) {
                    System.out.println("Jogador 02 Venceu!");
                } else if (!JogoDaVelha.verificaSeHaJogo(tabuleiro, jogadasRestantes, 'X')){
                    System.out.println("Deu Velha!");
                }
            }
        }
    }
}