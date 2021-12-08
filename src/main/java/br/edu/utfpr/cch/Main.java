package br.edu.utfpr.cch;

public class Main {

    public static void main(String[] args) {

        Hash hash = new Hash(4);
        hash.inserir(new Contato(2, "Saulo", "99990000"));
        hash.inserir(new Contato(6, "Joao", "99009900"));
        hash.inserir(new Contato(13, "Marta", "99778877"));
        hash.inserir(new Contato(12, "Roberta", "87872222"));
        hash.inserir(new Contato(7, "Maria", "77887777"));

        System.out.println(hash);
    }

}
