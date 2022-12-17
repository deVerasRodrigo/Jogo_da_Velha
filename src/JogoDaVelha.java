import java.util.Scanner;

public class JogoDaVelha {
    public static void imprimirTabuleiro (Character[][] tabuleiro){
        for (int indiceLinha = 0; indiceLinha < tabuleiro.length; indiceLinha++) {

            Character [] linha = tabuleiro[indiceLinha];
            System.out.println("---------------");

            for (int indiceColuna = 0; indiceColuna < linha.length; indiceColuna++) {
                Character posicao = tabuleiro[indiceLinha][indiceColuna];

                if (posicao == null){
                    System.out.print(" |  ");
                } else {
                    System.out.print(" | " + posicao);
                }
                if (indiceColuna == linha.length-1){
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
    private static boolean jogadaValida (Character[][] tabuleiro, int[] jogada){
        int linhaEscolhida = jogada [0];
        int colunaEscolhida = jogada [1];

        if (linhaEscolhida < 1 || linhaEscolhida > 3){
            return false;
        }
        if (colunaEscolhida < 1 || colunaEscolhida > 3){
            return false;
        }
        if (tabuleiro[linhaEscolhida-1][colunaEscolhida-1] != null){
            return false;
        }
        return true;
    }
    private static int [] jogarSimbolo (Character[][] tabuleiro, Scanner scanner){
        int [] jogada = new int[2];

        jogada [0] = scanner.nextInt();
        jogada [1] = scanner.nextInt();

        while (!jogadaValida(tabuleiro, jogada)){
            System.out.println("Jogada inválida! tente novamente:");
            jogada [0] = scanner.nextInt();
            jogada [1] = scanner.nextInt();
        }
        return jogada;
    }
    public static void jogadaDeX (Character[][] tabuleiro, Scanner scanner){
        System.out.println("Jogador 1 (X) faça sua jogada:");

        int [] jogadaX = jogarSimbolo(tabuleiro, scanner);

        tabuleiro[jogadaX[0]-1][jogadaX[1]-1] = 'X';
    }
    public static void jogadaDeO (Character[][] tabuleiro, Scanner scanner){
        System.out.println("Jogador 2 (O) faça sua jogada:");

        int [] jogadaO = jogarSimbolo(tabuleiro, scanner);

        tabuleiro[jogadaO[0]-1][jogadaO[1]-1] = 'O';
    }
    public static boolean verificarSeVenceu(Character [][] tabuleiro){
        if (contarLinhasIguais(tabuleiro) > 0 || contarColunasIguais(tabuleiro) > 0 || verificarDiagonaisIguais(tabuleiro)){
            return true;
        } else {
            return false;
        }
    }
    private static int contarLinhasIguais(Character[][] tabuleiro){
        int linhasIguais = 0;
        int elementosIguaisNaLinha = 0;
        for (Character[] linha : tabuleiro) {
            for (Character posicao : linha) {
                Character elementoNaColuna0 = linha[0];
                if (posicao == elementoNaColuna0 && elementoNaColuna0 != null) {
                    elementosIguaisNaLinha++;
                }
                if (elementosIguaisNaLinha == 3){
                    linhasIguais++;
                }
            }
            elementosIguaisNaLinha = 0;
        }
        return linhasIguais;
    }

    //PRA LEMBRAR: MUDAR O NOME DO CODIGO PARA CONTAR LINHAS IGUAIS, ADICIONAR UM CONTADOR PRA SOMAR A QUANTIDADE DE LINHAS OU COLUNAS OU DIAGONAIS IGUAIS!
    private static int contarColunasIguais(Character[][] tabuleiro){
        int colunasIguais = 0;
        int elementosIguaisNaColuna = 0;

        for (int indiceColuna = 0; indiceColuna < tabuleiro[0].length; indiceColuna++) {
            for (int indiceLinha = 0; indiceLinha < tabuleiro.length; indiceLinha++) {
                Character posicao = tabuleiro[indiceLinha][indiceColuna];
                Character elementoNaLinha0 = tabuleiro[0][indiceColuna];
                if (posicao == elementoNaLinha0 && elementoNaLinha0 != null) {
                    elementosIguaisNaColuna++;
                }
                if (elementosIguaisNaColuna == 3){
                    colunasIguais++;
                }
            }
            elementosIguaisNaColuna = 0;
        }
        return colunasIguais;
    }
    private static boolean verificarDiagonaisIguais (Character[][] tabuleiro){
        if (tabuleiro[0][0] == tabuleiro [1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != null){
            return true;
        }
        if (tabuleiro[0][2] == tabuleiro [1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != null){
            return true;
        }
        else{
            return false;
        }
    }
}
