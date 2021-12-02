package br.edu.utfpr.atv4;

public interface ListaContatoInt {

    int inserirContatoInicio(ListaContato lista, Contato contato);

    int inserirContatoFinal(ListaContato lista, Contato contato);

    Integer buscarContatoPorEmail(ListaContato lista, String email, Contato contatoEncontrado);

    Integer removerContatoPorEmail(ListaContato lista, String email);

    Integer tamanhoLista(ListaContato lista);

}
