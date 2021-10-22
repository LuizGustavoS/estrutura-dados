package br.edu.utfpr.pilha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final PilhaImpl pilhaImpl = new PilhaImpl();
        Pilha pilha = new Pilha();

        while (true){
            printarMenu();
            final int opcao = new Scanner(System.in).nextInt();
            if (opcao == 0){
                break;
            }

            if (opcao == 1){
                System.out.println("Insira o valor:");
                final int valor = new Scanner(System.in).nextInt();
                pilhaImpl.adicionarValor(pilha, valor);
                System.out.println("Dado adicionado com sucesso");
            }else if (opcao == 2){
                pilhaImpl.removerValor(pilha);
                System.out.println("Dado removido com sucesso");
            }else if (opcao == 3){
                pilhaImpl.printarPilha(pilha);
            }else {
                System.out.println("Opção invalida!");
            }
        }
    }

    static void printarMenu(){
        System.out.println("1 - INSERIR ITEM");
        System.out.println("2 - REMOVER ITEM");
        System.out.println("3 - PRINTAR ITENS");
        System.out.println("0 - SAIR");
    }

}
