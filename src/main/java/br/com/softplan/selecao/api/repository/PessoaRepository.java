package br.com.softplan.selecao.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.selecao.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
