package br.edu.utfpr.cch;

public class Hash {

    int operador;
    Lista[] vetor;
 
    public Hash(int operador) {
        this.operador = operador;
        vetor = new Lista[operador];
        for (int i = 0; i < operador; i++) {
            vetor[i] = new Lista();
        }
    }

    void inserir(Contato contato) {
        int chave = contato.codigo % operador;
        vetor[chave].inserir(contato);
    }

    Contato buscar(int codigo) {
        return vetor[codigo % operador].buscar(codigo);
    }

    public String toString() {
        String out = "";
        for(int i = 0; i < operador; i++) {
            out += "" + i + ": ";
            out += vetor[i % operador] + "\n";
        }
        return out;
    }
}