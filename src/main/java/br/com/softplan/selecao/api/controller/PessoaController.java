package br.com.softplan.selecao.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.selecao.api.dto.PessoaCadastroDTO;
import br.com.softplan.selecao.api.dto.PessoaRetornoDTO;
import br.com.softplan.selecao.api.exception.ResourceNotFoundException;
import br.com.softplan.selecao.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaRetornoDTO find(@PathVariable Integer id) throws ResourceNotFoundException {
		return this.pessoaService.find(id);
	}

	@GetMapping
	public Page<PessoaRetornoDTO> findAll(Pageable pageable) {
		return pessoaService.findAll(pageable);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaRetornoDTO create(@RequestBody @Valid PessoaCadastroDTO dto) throws ResourceNotFoundException {
		return this.pessoaService.create(dto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody @Valid PessoaCadastroDTO dto) throws ResourceNotFoundException {
		this.pessoaService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Integer id) throws ResourceNotFoundException {
		this.pessoaService.delete(id);
	}
}