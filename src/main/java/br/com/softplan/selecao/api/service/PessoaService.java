package br.com.softplan.selecao.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.softplan.selecao.api.dto.PessoaCadastroDTO;
import br.com.softplan.selecao.api.dto.PessoaRetornoDTO;
import br.com.softplan.selecao.api.model.Pessoa;
import br.com.softplan.selecao.api.model.Sexo;
import br.com.softplan.selecao.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Optional<PessoaRetornoDTO> find(Integer id) {
		return this.pessoaRepository.findById(id).map(this::toDTO);
	}

	public Page<PessoaRetornoDTO> findAll(Pageable pageable) {
		Page<Pessoa> page = this.pessoaRepository.findAll(pageable);
		Page<PessoaRetornoDTO> pageDTO = page.map(this::toDTO);

		return pageDTO;
	}

	public PessoaRetornoDTO create(PessoaCadastroDTO dto) throws Exception {
		Pessoa pessoa = this.pessoaRepository.save(this.toEntity(dto));

		return this
			.find(pessoa.getId())
			.orElseThrow(() -> new Exception("Erro ao salvar Pessoa"));
	}

	public PessoaRetornoDTO update(Integer id, PessoaCadastroDTO dto) throws Exception {
		Pessoa pessoa = this.pessoaRepository
			.findById(id)
			.orElseThrow(() -> new Exception("Pessoa não encontrada"));

		pessoa = this.updateFromDTO(pessoa, dto);

		this.pessoaRepository.save(pessoa);

		return this
			.find(pessoa.getId())
			.orElseThrow(() -> new Exception("Erro ao salvar Pessoa"));
	}

	public void delete(Integer id) throws Exception {
		Pessoa pessoa = this.pessoaRepository
			.findById(id)
			.orElseThrow(() -> new Exception("Pessoa não encontrada"));

		this.pessoaRepository.delete(pessoa);
	}

	private PessoaRetornoDTO toDTO(Pessoa pessoa) {
		PessoaRetornoDTO dto = new PessoaRetornoDTO();

		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setSexo(pessoa.getSexo().getValor());
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
		pessoa.setSexo(Sexo.valueOf(dto.getSexo()));
		pessoa.setEmail(dto.getEmail());
		pessoa.setDataNascimento(dto.getDataNascimento());
		pessoa.setNaturalidade(dto.getNaturalidade());
		pessoa.setNacionalidade(dto.getNacionalidade());
		pessoa.setCpf(dto.getCpf());
		
		return pessoa;
	}
}