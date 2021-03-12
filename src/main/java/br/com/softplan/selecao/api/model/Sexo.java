package br.com.softplan.selecao.api.model;

public enum Sexo {
	MASCULINO("M"),
	FEMININO("F");

	private final String valor;

	private Sexo(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}
}
