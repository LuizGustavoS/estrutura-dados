import java.util.Scanner;

public class Main extends ListaContatoImpl {

    static ListaContatoInt ContatoCtrl = new ListaContatoImpl();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ListaContato listaContato = ContatoCtrl.criarListaEncadeadaContatos();

        int opcao;
        while (true) {
            imprimirMenu();
            opcao = scanner.nextInt();

            if (opcao == 0){
                break;
            }

            switch (opcao) {
                case 1 -> inserirContato(listaContato, true);
                case 2 -> inserirContato(listaContato, false);
                case 3 -> {
                    Contato contato = new Contato();
                    System.out.println("Insira o email");
                    final String email = new Scanner(System.in).nextLine();
                    ContatoCtrl.buscarContatoPorEmail(listaContato, email, contato);
                    ContatoCtrl.imprimirDadosContato(contato);
                }
                case 6 -> ContatoCtrl.imprimirListaContatos(listaContato);
                default -> System.out.println("Opcao invalida");
            }
        }
    }

    static void imprimirMenu(){
        System.out.println("GERENCIADOR DE CONTATOS");
        System.out.println("=======================");
        System.out.println("Escolha uma opcao:");
        System.out.println("1 - Inserir novo contato no inicio");
        System.out.println("2 - Inserir novo contato no final");
        System.out.println("3 - Recuperar um contato (email)");
        System.out.println("4 - Recuperar contatos (mes aniversario)");
        System.out.println("5 - Remover um contato");
        System.out.println("6 - Imprimir toda lista de contatos");
        System.out.println("0 - Fechar o programa");
    }

    static void inserirContato(ListaContato listaContato, boolean inicio){

        final Scanner scanner = new Scanner(System.in);
        Contato contato = new Contato();

        System.out.println("Insira o nome");
        contato.nome = scanner.nextLine();

        System.out.println("Insira o sobrenome");
        contato.sobrenome = scanner.nextLine();

        System.out.println("Insira o email");
        contato.email = scanner.nextLine();

        System.out.println("Insira o telefone");
        contato.telefone = scanner.nextLine();

        System.out.println("Insira a data de nascimento dd/MM/aaaa");
        String data = scanner.nextLine();
        data = data.replace("/", "");
        contato.diaNascimento = Integer.parseInt(data.substring(0, 2));
        contato.mesNascimento = Integer.parseInt(data.substring(2, 4));
        contato.anoNascimento = Integer.parseInt(data.substring(4));

        System.out.println("Insira a profissao");
        contato.profissao = scanner.nextLine();

        if (inicio){
            ContatoCtrl.inserirContatoInicio(listaContato, contato);
        }else {
            ContatoCtrl.inserirContatoFinal(listaContato, contato);
        }
    }

}
