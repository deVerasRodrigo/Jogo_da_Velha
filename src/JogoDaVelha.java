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

}
