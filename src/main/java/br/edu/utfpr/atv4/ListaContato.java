package br.edu.utfpr.atv4;

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

    public Contato(){}

    public Contato(String nome, String sobrenome, String email, String telefone,
                   int diaNascimento, int mesNascimento, int anoNascimento, String profissao) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.profissao = profissao;
    }
}



