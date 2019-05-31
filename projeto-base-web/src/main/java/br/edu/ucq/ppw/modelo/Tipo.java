package br.edu.ucq.ppw.modelo;

public enum Tipo {

	RECEITA("Receita"), DESPESA("Despesa");

	Tipo(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}
