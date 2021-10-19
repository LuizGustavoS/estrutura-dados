package encadedada;

public class ListaContatoImpl implements ListaContatoInt {

    public void imprimirDadosContato(Contato contato) {
        System.out.println("Dados do encadedada.Contato:");
        System.out.println("*****************");
        System.out.println("Nome: " + contato.nome);
        System.out.println("Sobrenome: " + contato.sobrenome);
        System.out.println("Email: " + contato.email);
        System.out.println("Telefone: " + contato.telefone);
        System.out.printf("Data Nascimento: %d/%d/%d \n", contato.diaNascimento, contato.mesNascimento, contato.anoNascimento);
        System.out.println("Profissao: " + contato.profissao);
        System.out.println("*****************\n");
    }

    public ListaContato criarListaEncadeadaContatos() {
        return new ListaContato();
    }

    public void destruirListaEncadeadaContatos(ListaContato lista) {

    }

    public int inserirContatoInicio(ListaContato lista, Contato contato) {
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

    public int buscarContatoPorEmail(ListaContato lista, String email, Contato contatoEncontrado) {

        if (lista.inicio == null){
            System.out.println("Lista não iniciada!");
            return 0;
        }

        Nodo nodo = lista.inicio;
        do {
            if (nodo.contato.email.equals(email)){
                copy(nodo.contato, contatoEncontrado);
                break;
            }
            nodo = nodo.proximo;
        }while (nodo.proximo != null);

        return 1;
    }

    public int removerContatoPorEmail(ListaContato lista, String email) {

        if (lista.inicio == null){
            return 0;
        }

        Nodo inicio = lista.inicio;
        if (inicio.contato.email.equals(email)){
            lista.inicio = lista.inicio.proximo;
            return 1;
        }

        Nodo nodoParaRemover = lista.inicio;
        while (nodoParaRemover.proximo != null){
            if (nodoParaRemover.contato.email.equals(email)){
                break;
            }
            nodoParaRemover = nodoParaRemover.proximo;
        }

        Nodo nodoAnterior = inicio;
        while (nodoAnterior.proximo != null && !nodoAnterior.proximo.equals(nodoParaRemover)){
            nodoAnterior = nodoAnterior.proximo;
        }

        nodoAnterior.proximo = nodoParaRemover.proximo;
        return 1;
    }

    public int tamanhoLista(ListaContato lista) {

        Nodo nodo = lista.inicio;
        if (nodo == null){
            return 0;
        }

        int i=1;
        while (nodo.proximo != null) {
            nodo = nodo.proximo;
            i++;
        }

        return i;
    }

    public void imprimirListaContatos(ListaContato lista) {

        if (lista == null){
            System.out.println("Lista não localizada!");
            return;
        }

        Nodo nodo = lista.inicio;
        while (nodo != null){
            imprimirDadosContato(nodo.contato);
            nodo = nodo.proximo;
        }
    }

    public void imprimirListaContatosPorMesNascimento(ListaContato lista, int mesNascimento) {

        Nodo nodo = lista.inicio;
        while (nodo != null){
            if (nodo.contato.mesNascimento == mesNascimento){
                imprimirDadosContato(nodo.contato);
            }
            nodo = nodo.proximo;
        }
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
