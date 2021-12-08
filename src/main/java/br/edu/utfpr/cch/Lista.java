package br.edu.utfpr.cch;

public class Lista {

     No inicio;
     int tamanho;
 
     public void inserir(Contato info) {
         No no = new No();
         no.info = info;
         no.proximo = inicio;
         inicio = no;
         tamanho++;
    }

    public Contato buscar(int codigo) {
        No no = inicio;
        while (no != null) {
            if (no.info.codigo == codigo) {
                return no.info;
            }
            no = no.proximo;
        }
        return null;
    }

    public String toString() {
        String out = "";
        No no = inicio;
        while (no != null) {
            out += no.info + " ";
            no = no.proximo;
        }
        return out;
    }
}