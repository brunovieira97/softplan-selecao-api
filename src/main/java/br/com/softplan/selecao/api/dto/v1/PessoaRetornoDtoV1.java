package br.com.softplan.selecao.api.dto.v1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaRetornoDtoV1 {
	
	private Integer id;
	private String nome;
	private String sexo;
	private String email;
	private LocalDate dataNascimento;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	
	public PessoaRetornoDtoV1() {
	}
	
	public PessoaRetornoDtoV1(Integer id, String nome, String sexo, String email, LocalDate dataNascimento,
			String naturalidade, String nacionalidade, String cpf, LocalDateTime dataCriacao,
			LocalDateTime dataAtualizacao) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
