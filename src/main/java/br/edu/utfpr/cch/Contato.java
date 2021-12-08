package br.edu.utfpr.cch;

public class Contato {

	int codigo;
	String nome;
	String telefone;

	Contato(int codigo, String nome, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
	}

	public String toString() {
		return "(" + codigo + ", " + nome + ")";
	}

}