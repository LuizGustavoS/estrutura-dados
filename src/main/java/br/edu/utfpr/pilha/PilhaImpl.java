package br.edu.utfpr.pilha;

class PilhaImpl implements PilhaInterface {

    public void adicionarValor(Pilha pilha, Integer valor){

        Nodo novoNodo = new Nodo(valor);
        if (pilha.inicio != null){
            novoNodo.proximo = pilha.inicio;
        }

        pilha.inicio = novoNodo;
    }

    public void removerValor(Pilha pilha){

        if (pilha.inicio == null){
            System.out.println("Nao existe nenhum item na lista");
        }else if (pilha.inicio.proximo == null){
            pilha.inicio = null;
        }else {
            pilha.inicio = pilha.inicio.proximo;
        }
    }

    public void printarPilha(Pilha pilha){

        System.out.println("-----------------------------");
        Nodo nodo = pilha.inicio;
        while (nodo != null){
            System.out.println(nodo.item.valor);
            nodo = nodo.proximo;
        }
        System.out.println("-----------------------------");
    }

}
