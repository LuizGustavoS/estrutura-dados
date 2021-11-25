package br.edu.utfpr.atv3;

public class OrdenacaoImpl implements Ordenacao {

    public Result insertionSort(int[] valores) {

        int qtdeComp = 0, qtdeTroca = 0;
        int n = valores.length;
        for (int j = 1; j < n; j++) {

            int key = valores[j];
            int i = j - 1;

            while ((i > -1) && (valores[i] > key)) {
                qtdeComp++;
                qtdeTroca++;
                valores[i + 1] = valores[i];
                i--;
            }

            valores[i + 1] = key;
        }

        return new Result(qtdeComp, qtdeTroca);
    }

    public Result selectionSort(int[] valores){

        int qtdeComp = 0, qtdeTroca = 0;
        for (int i = 0; i < valores.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < valores.length; j++){
                if (valores[j] < valores[index]){
                    index = j;
                    qtdeComp++;
                }
            }
            int menor = valores[index];
            valores[index] = valores[i];
            valores[i] = menor;
            qtdeTroca++;
        }

        return new Result(qtdeComp, qtdeTroca);
    }

    public Result bubbleSort(int[] valores) {

        int temp;
        int n = valores.length;
        int qtdeComp = 0, qtdeTroca = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                qtdeComp++;
                if(valores[j-1] > valores[j]){
                    temp = valores[j-1];
                    valores[j-1] = valores[j];
                    valores[j] = temp;
                    qtdeTroca++;
                }
            }
        }

        return new Result(qtdeComp, qtdeTroca);
    }

}
