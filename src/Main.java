import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character[][] tabuleiro = new Character[3][3];
        Scanner scanner = new Scanner(System.in);

        JogoDaVelha.imprimirTabuleiro(tabuleiro);


        while (!JogoDaVelha.verificarSeVenceu(tabuleiro)) {

            JogoDaVelha.jogadaDeX(tabuleiro, scanner);
            JogoDaVelha.imprimirTabuleiro(tabuleiro);

            if (JogoDaVelha.verificarSeVenceu(tabuleiro)) {
                System.out.println("Jogador 01 Venceu!");
            } else {
                JogoDaVelha.jogadaDeO(tabuleiro, scanner);
                JogoDaVelha.imprimirTabuleiro(tabuleiro);
                if (JogoDaVelha.verificarSeVenceu(tabuleiro)) {
                    System.out.println("Jogador 02 Venceu!");
                }
            }
        }
    }
}