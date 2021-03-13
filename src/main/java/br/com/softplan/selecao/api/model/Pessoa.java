package br.com.softplan.selecao.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@Nullable
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Email
	@Nullable
	private String email;

	@Past
	@NotNull
	private LocalDate dataNascimento;
	
	@Nullable
	private String naturalidade;
	
	@Nullable
	private String nacionalidade;
	
	@CPF
	@NotBlank
	@Column(unique = true)
	private String cpf;

	@CreatedDate
	private LocalDateTime dataCriacao;

	@LastModifiedDate
	private LocalDateTime dataAtualizacao;
	
	public Pessoa() {
	}
	
	public Pessoa(Integer id, String nome, Sexo sexo, String email, LocalDate dataNascimento, String naturalidade,
			String nacionalidade, String cpf) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return this.naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataCriacao() {
		return this.dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return this.dataAtualizacao;
	}

	
}
