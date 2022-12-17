import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character [][] tabuleiro = new Character[3][3];
        Scanner scanner = new Scanner(System.in);

        JogoDaVelha.imprimirTabuleiro(tabuleiro);

        JogoDaVelha.jogadaDeX(tabuleiro, scanner);
        JogoDaVelha.imprimirTabuleiro(tabuleiro);

        JogoDaVelha.jogadaDeO(tabuleiro, scanner);
        JogoDaVelha.imprimirTabuleiro(tabuleiro);

        JogoDaVelha.jogadaDeX(tabuleiro, scanner);
        JogoDaVelha.imprimirTabuleiro(tabuleiro);

        JogoDaVelha.jogadaDeO(tabuleiro, scanner);
        JogoDaVelha.imprimirTabuleiro(tabuleiro);


    }
}