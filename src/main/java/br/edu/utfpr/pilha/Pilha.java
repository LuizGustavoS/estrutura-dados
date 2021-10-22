package br.edu.utfpr.pilha;

class Pilha {
    Nodo inicio;
}

class Nodo {

    Item item;

    Nodo proximo;

    public Nodo(Integer valor) {
        this.item = new Item(valor);
    }
}

class Item {

    Integer valor;

    public Item(Integer valor) {
        this.valor = valor;
    }
}

interface PilhaInterface{

    void adicionarValor(Pilha pilha, Integer valor);

    void removerValor(Pilha pilha);

    void printarPilha(Pilha pilha);

}