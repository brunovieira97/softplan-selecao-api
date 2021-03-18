package br.com.softplan.selecao.api.service.v2;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.selecao.api.dto.v2.PessoaCadastroDtoV2;
import br.com.softplan.selecao.api.dto.v2.PessoaRetornoDtoV2;
import br.com.softplan.selecao.api.exception.ResourceNotFoundException;
import br.com.softplan.selecao.api.model.Pessoa;
import br.com.softplan.selecao.api.repository.PessoaRepository;

@Service
public class PessoaServiceV2 {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaRetornoDtoV2 findById(Integer id) throws ResourceNotFoundException {
		return this.pessoaRepository
			.findById(id)
			.map(this::toDTO)
			.orElseThrow(ResourceNotFoundException::new);
	}

	public List<PessoaRetornoDtoV2> findAll() {
		return this.pessoaRepository
			.findAll()
			.stream()
			.map(this::toDTO)
			.collect(Collectors.toList());
	}

	@Transactional
	public Integer create(PessoaCadastroDtoV2 dto) throws ResourceNotFoundException {
		return this.pessoaRepository
			.save(this.toEntity(dto))
			.getId();
	}

	@Transactional
	public void update(Integer id, PessoaCadastroDtoV2 dto) throws ResourceNotFoundException {
		Pessoa pessoa = this.pessoaRepository
			.findById(id)
			.orElseThrow(ResourceNotFoundException::new);

		pessoa = this.updateFromDTO(pessoa, dto);

		this.pessoaRepository.save(pessoa);
	}

	public void delete(Integer id) throws ResourceNotFoundException {
		Pessoa pessoa = this.pessoaRepository
			.findById(id)
			.orElseThrow(ResourceNotFoundException::new);

		this.pessoaRepository.delete(pessoa);
	}

	private PessoaRetornoDtoV2 toDTO(Pessoa pessoa) {
		PessoaRetornoDtoV2 dto = new PessoaRetornoDtoV2();

		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setSexo(pessoa.getSexo());
		dto.setEmail(pessoa.getEmail());
		dto.setDataNascimento(pessoa.getDataNascimento());
		dto.setNaturalidade(pessoa.getNaturalidade());
		dto.setNacionalidade(pessoa.getNacionalidade());
		dto.setCpf(pessoa.getCpf());
		dto.setDataCriacao(pessoa.getDataCriacao());
		dto.setDataAtualizacao(pessoa.getDataAtualizacao());
		dto.setEndereco(pessoa.getEndereco());

		return dto;
	}

	private Pessoa toEntity(PessoaCadastroDtoV2 dto) {
		Pessoa pessoa = new Pessoa();

		return updateFromDTO(pessoa, dto);
	}

	private Pessoa updateFromDTO(Pessoa pessoa, PessoaCadastroDtoV2 dto) {
		pessoa.setNome(dto.getNome());
		pessoa.setSexo(dto.getSexo());
		pessoa.setEmail(dto.getEmail());
		pessoa.setDataNascimento(dto.getDataNascimento());
		pessoa.setNaturalidade(dto.getNaturalidade());
		pessoa.setNacionalidade(dto.getNacionalidade());
		pessoa.setCpf(dto.getCpf());
		pessoa.setEndereco(dto.getEndereco());
		
		return pessoa;
	}
}
