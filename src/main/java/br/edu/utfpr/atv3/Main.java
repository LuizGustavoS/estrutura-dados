package br.edu.utfpr.atv3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

/*        int i = 0;
        int[] valores = new int[25];

        while (true) {
            int entrada;
            System.out.println("Insira o numero " + i + 1);

            try {
                entrada = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Valor invalido");
                continue;
            }

            if (entrada == 0) {
                break;
            }

            if (entrada < 0 || entrada > 100) {
                System.out.println("Somente sao permitidas entradas entre 1 e 100");
                continue;
            }

            valores[i] = entrada;

            if (i == 24) {
                break;
            }
            i++;
        }*/

        Ordenacao ordenacao = new OrdenacaoImpl();
        int[] valores = {9,14,3,2,43,11,58,22};

        Result r1 = ordenacao.insertionSort(Arrays.copyOf(valores, valores.length));
        Result r2 = ordenacao.selectionSort(Arrays.copyOf(valores, valores.length));
        Result r3 = ordenacao.bubbleSort(valores);

        String content = "";
        for (int v : valores) {
            content = content.concat(v + ", ");
        }

        System.out.println(content.substring(0, content.length() -2));
        System.out.println("Insertion Sort: comparações: " + r1.qtdeComp + " trocas: " + r1.qtdeTroca);
        System.out.println("Selection Sort: comparações: " + r2.qtdeComp + " trocas: " + r2.qtdeTroca);
        System.out.println("BubbleSort: comparações: " + r3.qtdeComp + " trocas: " + r3.qtdeTroca);
    }

}
