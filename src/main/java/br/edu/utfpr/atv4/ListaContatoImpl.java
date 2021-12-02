package br.edu.utfpr.atv4;

import br.edu.utfpr.atv3.Result;

public class ListaContatoImpl implements ListaContatoInt {

    public int inserirContatoInicio(br.edu.utfpr.atv4.ListaContato lista, Contato contato) {
        lista.inicio = new Nodo(contato, lista.inicio);
        return 1;
    }

    public int inserirContatoFinal(ListaContato lista, Contato contato) {

        if (lista.inicio == null) {
            lista.inicio = new Nodo(contato);
            return 1;
        }

        Nodo nodo = lista.inicio;
        while (nodo.proximo != null) {
            nodo = nodo.proximo;
        }
        nodo.proximo = new Nodo(contato);
        return 1;
    }

    public Integer buscarContatoPorEmail(ListaContato lista, String email, Contato contatoEncontrado) {

        if (lista.inicio == null){
            return null;
        }

        int count = 1;
        Nodo nodo = lista.inicio;
        while (nodo != null){
            if (nodo.contato.email.equals(email)){
                copy(nodo.contato, contatoEncontrado);
                return count;
            }

            nodo = nodo.proximo;
        }

        return null;
    }

    public Integer removerContatoPorEmail(ListaContato lista, String email) {

        if (lista.inicio == null){
            return null;
        }

        int qtde = 1;
        Nodo inicio = lista.inicio;
        if (inicio.contato.email.equals(email)){
            lista.inicio = lista.inicio.proximo;
            return qtde;
        }

        boolean encontrou = false;
        Nodo nodoParaRemover = lista.inicio;
        while (nodoParaRemover.proximo != null){
            if (nodoParaRemover.contato.email.equals(email)){
                encontrou = true;
                break;
            }
            nodoParaRemover = nodoParaRemover.proximo;
            qtde++;
        }

        if (!encontrou){
            return null;
        }

        Nodo nodoAnterior = inicio;
        while (nodoAnterior.proximo != null && !nodoAnterior.proximo.equals(nodoParaRemover)){
            nodoAnterior = nodoAnterior.proximo;
        }

        nodoAnterior.proximo = nodoParaRemover.proximo;
        return qtde;
    }

    public Integer tamanhoLista(ListaContato lista) {

        Nodo nodo = lista.inicio;
        if (nodo == null){
            return null;
        }

        int i=1;
        while (nodo.proximo != null) {
            nodo = nodo.proximo;
            i++;
        }

        return i;
    }

    private void copy(Contato from, Contato to){
        to.nome = from.nome;
        to.sobrenome = from.sobrenome;
        to.email = from.email;
        to.telefone = from.telefone;
        to.diaNascimento = from.diaNascimento;
        to.mesNascimento = from.mesNascimento;
        to.anoNascimento = from.anoNascimento;
        to.profissao = from.profissao;
    }
}
