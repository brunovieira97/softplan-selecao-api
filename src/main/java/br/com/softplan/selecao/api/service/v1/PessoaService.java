package br.com.softplan.selecao.api.service.v1;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.selecao.api.dto.v1.PessoaCadastroDTO;
import br.com.softplan.selecao.api.dto.v1.PessoaRetornoDTO;
import br.com.softplan.selecao.api.exception.ResourceNotFoundException;
import br.com.softplan.selecao.api.model.Pessoa;
import br.com.softplan.selecao.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public PessoaRetornoDTO findById(Integer id) throws ResourceNotFoundException {
		return this.pessoaRepository
			.findById(id)
			.map(this::toDTO)
			.orElseThrow(ResourceNotFoundException::new);
	}

	public List<PessoaRetornoDTO> findAll() {
		return this.pessoaRepository
			.findAll()
			.stream()
			.map(this::toDTO)
			.collect(Collectors.toList());
	}

	@Transactional
	public Integer create(PessoaCadastroDTO dto) throws ResourceNotFoundException {
		return this.pessoaRepository
			.save(this.toEntity(dto))
			.getId();
	}

	@Transactional
	public void update(Integer id, PessoaCadastroDTO dto) throws ResourceNotFoundException {
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

	private PessoaRetornoDTO toDTO(Pessoa pessoa) {
		PessoaRetornoDTO dto = new PessoaRetornoDTO();

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

		return dto;
	}

	private Pessoa toEntity(PessoaCadastroDTO dto) {
		Pessoa pessoa = new Pessoa();

		return updateFromDTO(pessoa, dto);
	}

	private Pessoa updateFromDTO(Pessoa pessoa, PessoaCadastroDTO dto) {
		pessoa.setNome(dto.getNome());
		pessoa.setSexo(dto.getSexo());
		pessoa.setEmail(dto.getEmail());
		pessoa.setDataNascimento(dto.getDataNascimento());
		pessoa.setNaturalidade(dto.getNaturalidade());
		pessoa.setNacionalidade(dto.getNacionalidade());
		pessoa.setCpf(dto.getCpf());
		
		return pessoa;
	}
}
