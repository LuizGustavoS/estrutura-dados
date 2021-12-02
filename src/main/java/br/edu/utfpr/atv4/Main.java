package br.edu.utfpr.atv4;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0 || args[0] == null){
            throw new Exception("Por favor, informe o local da pasta dos arquivos atraves dos argumentos do programa");
        }

        String path = args[0];
        path = path.endsWith("/")? path : path + "/";

        String logOperacao = "";

        ListaContato listaContato = new ListaContato();
        ListaContatoImpl contatoImpl = new ListaContatoImpl();

        try {
            final String operacoes = carregarArquivo(path);
            String[] listOperacoes = operacoes.split("\n");
            for (String linha : listOperacoes) {

                String mensagem = "";
                final String op = linha.split(",")[0];

                switch (op) {
                    case "inserir_inicio": {
                        Contato contato = carregarDadosContato(linha);
                        final int result = contatoImpl.inserirContatoInicio(listaContato, contato);
                        mensagem = String.valueOf(result);
                        break;
                    }
                    case "inserir_final": {
                        Contato contato = carregarDadosContato(linha);
                        final int result = contatoImpl.inserirContatoFinal(listaContato, contato);
                        mensagem = String.valueOf(result);
                        break;
                    }
                    case "remover": {
                        final Integer result = contatoImpl.removerContatoPorEmail(listaContato, linha.split(",")[1].trim());
                        mensagem = result == null ? "Contato nao encontrado" : String.valueOf(result);
                        break;
                    }
                    case "buscar": {
                        Contato contato = new Contato();
                        final Integer result = contatoImpl.buscarContatoPorEmail(listaContato, linha.split(",")[1].trim(), contato);
                        mensagem = result == null ? "Contato nao encontrado" : String.valueOf(result);
                        break;
                    }
                    case "obter_tamanho_lista": {
                        final Integer result = contatoImpl.tamanhoLista(listaContato);
                        mensagem = result == null ? "Lista nao iniciada" : String.valueOf(result);
                        break;
                    }
                }

                logOperacao += op + "," +  mensagem + "\n";
            }

            FileUtils.writeStringToFile(
                    new File(path + "log-operacoes.txt"),
                    logOperacao.substring(0, logOperacao.length() -1),
                    StandardCharsets.UTF_8);

            gravarLogDados(listaContato, path);

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private static Contato carregarDadosContato(String linha){
        final String[] listDados = linha.split(",");
        return new Contato(
                listDados[1],
                listDados[2],
                listDados[3],
                listDados[4],
                Integer.parseInt(listDados[5]),
                Integer.parseInt(listDados[6]),
                Integer.parseInt(listDados[7]),
                listDados[8]
        );
    }

    private static void gravarLogDados(ListaContato listaContato, String path) throws Exception {

        String conteudo = "";

        int count = 1;
        Nodo nodo = listaContato.inicio;
        while (nodo != null){
            conteudo += count + ", EMAIL:" + nodo.contato.email + "\n";
            nodo = nodo.proximo;
            count++;
        }

        FileUtils.writeStringToFile(
                new File(path + "log-conteudo-lista.txt"),
                conteudo.substring(0, conteudo.length() -1),
                StandardCharsets.UTF_8);
    }

    private static String carregarArquivo(String filePath) throws Exception {
        final FileInputStream inputStream = new FileInputStream(filePath + "operacoes.txt");
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

}
