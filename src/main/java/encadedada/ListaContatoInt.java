package encadedada;

import encadedada.Contato;
import encadedada.ListaContato;

public interface ListaContatoInt {

    void imprimirDadosContato(Contato contato);

    ListaContato criarListaEncadeadaContatos();

    void destruirListaEncadeadaContatos(ListaContato lista);

    int inserirContatoInicio(ListaContato lista, Contato contato);

    int inserirContatoFinal(ListaContato lista, Contato contato);

    int buscarContatoPorEmail(ListaContato lista, String email, Contato contatoEncontrado);

    int removerContatoPorEmail(ListaContato lista, String email);

    int tamanhoLista(ListaContato lista);

    void imprimirListaContatos(ListaContato lista);

    void imprimirListaContatosPorMesNascimento(ListaContato lista, int mesNascimento);

}
