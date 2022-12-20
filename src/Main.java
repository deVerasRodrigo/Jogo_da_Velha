import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("O que deseja fazer?");
        System.out.println("[1] - Ver regras e instruções");
        System.out.println("[2] - Começar um jogo");
        char opcao = 0;

        opcao = scanner.next().charAt(0);

        while (opcao != '1' && opcao != '2') {
            System.out.println("Opção inválida. Digite 1 ou 2.");
            opcao = scanner.next().charAt(0);
        }
        if (opcao == '1') {
            JogoDaVelha.imprimirInstrucoes();
        } else {
            JogoDaVelha.jogar();
        }
    }
}