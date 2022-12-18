import java.util.Scanner;

public class JogoDaVelha {
    public static void jogar() {
        Character[][] tabuleiro = new Character[3][3];
        Scanner scanner = new Scanner(System.in);

        imprimirTabuleiro(tabuleiro);

        int jogadasRestantes = 9;

        while (!checaVencedor(tabuleiro) && verificaSeHaJogo(tabuleiro, jogadasRestantes, 'X')) {

            jogadaDeX(tabuleiro, scanner);
            imprimirTabuleiro(tabuleiro);
            jogadasRestantes--;

            if (checaVencedor(tabuleiro)) {
                System.out.println("**********************");
                System.out.println("* Jogador 01 Venceu! *");
                System.out.println("**********************");

            } else if (!verificaSeHaJogo(tabuleiro,jogadasRestantes, 'O') &&
                        !verificaSeHaJogo(tabuleiro, jogadasRestantes, 'X')) {
                System.out.println("**************");
                System.out.println("* Deu Velha! *");
                System.out.println("**************");
            } else {
                jogadaDeO(tabuleiro, scanner);
                imprimirTabuleiro(tabuleiro);
                jogadasRestantes--;

                if (checaVencedor(tabuleiro)) {
                    System.out.println("**********************");
                    System.out.println("* Jogador 02 Venceu! *");
                    System.out.println("**********************");
                } else if (!verificaSeHaJogo(tabuleiro, jogadasRestantes, 'X')){
                    System.out.println("**************");
                    System.out.println("* Deu Velha! *");
                    System.out.println("**************");
                }
            }
        }
    }
    public static void imprimirInstrucoes(){
        Character[][] tabuleiro = new Character[3][3];
        System.out.println("********************REGRAS E INSTRUÇÕES********************");
        System.out.println();
        System.out.println("* O jogo se dá em um tabuleiro quadrado com 9 casas:");
        imprimirTabuleiro(tabuleiro);
        System.out.println("* Cada jogador preencherá, alternadamente, uma casa\n" +
                           "  com seu símbolo.");
        System.out.println("* O jogador 01 preencherá as casas X;");
        System.out.println("* O jogador 02 preencherá as casas O;");
        System.out.println("* Para fazer uma jogada, o jogador deverá indicar\n" +
                           "  as coordenadas da seguinte forma:");
        System.out.println();
        System.out.println("[índice da linha(1,2 ou 3)] [índice da coluna(1,2 ou 3)]");
        System.out.println();
        System.out.println("Por exemplo:");
        System.out.println("Jogador 1 (X) faça sua jogada:");
        System.out.println("2 3");
        tabuleiro[1][2] = 'X';
        imprimirTabuleiro(tabuleiro);
        System.out.println();
        System.out.println("* Vence o jogador que completar uma linha, coluna ou\n" +
                           "  diagonal com 3 símbolos iguais!");
        System.out.println();
        System.out.println("Vamos começar?");
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println();
        jogar();

    }

    private static void imprimirTabuleiro (Character[][] tabuleiro){
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
    private static void jogadaDeX (Character[][] tabuleiro, Scanner scanner){
        System.out.println("Jogador 1 (X) faça sua jogada:");

        int [] jogadaX = jogarSimbolo(tabuleiro, scanner);

        tabuleiro[jogadaX[0]-1][jogadaX[1]-1] = 'X';
    }
    private static void jogadaDeO (Character[][] tabuleiro, Scanner scanner){
        System.out.println("Jogador 2 (O) faça sua jogada:");

        int [] jogadaO = jogarSimbolo(tabuleiro, scanner);

        tabuleiro[jogadaO[0]-1][jogadaO[1]-1] = 'O';
    }
    private static boolean checaVencedor(Character [][] tabuleiro){
        if (contarLinhasCompletas(tabuleiro) > 0 || contarColunasCompletas(tabuleiro) > 0 || verificarDiagonaisCompletas(tabuleiro)){
            return true;
        } else {
            return false;
        }
    }
    private static int contarLinhasCompletas(Character[][] tabuleiro){
        int linhasCompletas = 0;
        int elementosIguaisNaLinha = 0;
        for (Character[] linha : tabuleiro) {
            for (Character posicao : linha) {
                Character elementoNaColuna0 = linha[0];
                if (posicao == elementoNaColuna0 && elementoNaColuna0 != null) {
                    elementosIguaisNaLinha++;
                }
                if (elementosIguaisNaLinha == 3){
                    linhasCompletas++;
                }
            }
            elementosIguaisNaLinha = 0;
        }
        return linhasCompletas;
    }
    private static int contarColunasCompletas(Character[][] tabuleiro){
        int colunasCompletas = 0;
        int elementosIguaisNaColuna = 0;

        for (int indiceColuna = 0; indiceColuna < 3; indiceColuna++) {
            for (int indiceLinha = 0; indiceLinha < 3; indiceLinha++) {
                Character posicao = tabuleiro[indiceLinha][indiceColuna];
                Character elementoNaLinha0 = tabuleiro[0][indiceColuna];
                if (posicao == elementoNaLinha0 && elementoNaLinha0 != null) {
                    elementosIguaisNaColuna++;
                }
                if (elementosIguaisNaColuna == 3){
                    colunasCompletas++;
                }
            }
            elementosIguaisNaColuna = 0;
        }
        return colunasCompletas;
    }
    private static boolean verificarDiagonaisCompletas (Character[][] tabuleiro){
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

    private static boolean verificaSeHaJogo(Character[][] tabuleiro, int jogadasRestantes, Character simbolo){

        if (jogadasRestantes > 2){
            return true;
        }

        for (int indiceLinha = 0; indiceLinha < 3; indiceLinha++) {
            int simbolosNaLinha = 0;
            int vaziosNaLinha = 0;
            for (int indiceColuna = 0; indiceColuna < 3; indiceColuna++) {
                if (tabuleiro[indiceLinha][indiceColuna] == simbolo){
                    simbolosNaLinha++;
                } else if (tabuleiro[indiceLinha][indiceColuna] == null){
                    vaziosNaLinha++;
                }
            }
            if (simbolosNaLinha == 2 && vaziosNaLinha == 1){
                return true;
            }
        }

        for (int indiceColuna = 0; indiceColuna < 3; indiceColuna++) {
            int simbolosNaColuna = 0;
            int vaziosNaColuna = 0;
            for (int indiceLinha = 0; indiceLinha < 3; indiceLinha++) {
                if (tabuleiro[indiceLinha][indiceColuna] == simbolo){
                    simbolosNaColuna++;
                } else if (tabuleiro[indiceLinha][indiceColuna] == null){
                    vaziosNaColuna++;
                }
            }
            if (simbolosNaColuna == 2 && vaziosNaColuna == 1){
                return true;
            }
        }

            int simbolosNaDiagonal = 0;
            int vaziosNaDiagonal = 0;
        for (int indiceLinha = 0; indiceLinha < 3; indiceLinha++) {
            int indiceColuna = indiceLinha;
            if (tabuleiro[indiceLinha][indiceColuna] == simbolo) {
                simbolosNaDiagonal++;
            }else if (tabuleiro[indiceLinha][indiceColuna] == null) {
                vaziosNaDiagonal++;
            }
        }
        if (simbolosNaDiagonal == 2 && vaziosNaDiagonal == 1){
            return true;
        }
        simbolosNaDiagonal = 0;
        vaziosNaDiagonal = 0;
        int indiceColuna = 2;
        for (int indiceLinha = 0; indiceLinha < 3; indiceLinha++){
            if (tabuleiro[indiceLinha][indiceColuna] == simbolo){
                simbolosNaDiagonal++;
            }else if (tabuleiro[indiceLinha][indiceColuna] == null ){
                vaziosNaDiagonal++;
            }
            indiceColuna--;
        }
        if (simbolosNaDiagonal == 2 && vaziosNaDiagonal == 1){
            return true;
        }
        return false;
    }
}
