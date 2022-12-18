import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("O que deseja fazer?");
        System.out.println("[1] - Ver regras e instruções");
        System.out.println("[2] - Começar um jogo");
        int opcao = scanner.nextInt();

        while (opcao != 1 && opcao != 2){
            System.out.println("Opção inválida. Digite 1 ou 2.");
            opcao = scanner.nextInt();
        }

        if (opcao == 1){
            JogoDaVelha.imprimirInstrucoes();
        } else {
            JogoDaVelha.jogar();
        }
    }
}