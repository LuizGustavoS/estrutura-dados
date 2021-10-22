package br.edu.utfpr.listaencadeada;

public class ListaContato {
    Nodo inicio;
}

class Nodo {
    Contato contato;
    Nodo proximo;

    public Nodo(Contato contato){
        this.contato = contato;
        this.proximo = null;
    }

    public Nodo(Contato contato, Nodo proximo){
        this.contato = contato;
        this.proximo = proximo;
    }
}

class Contato {
    String nome;
    String sobrenome;
    String email;
    String telefone;
    int diaNascimento;
    int mesNascimento;
    int anoNascimento;
    String profissao;
}



