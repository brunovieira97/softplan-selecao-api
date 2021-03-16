package br.com.softplan.selecao.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PessoaRetornoDTO find(@PathVariable Integer id) throws ResourceNotFoundException {
		return this.pessoaService.findById(id);
	}

	@GetMapping
	public List<PessoaRetornoDTO> findAll() {
		return pessoaService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaRetornoDTO create(@RequestBody @Valid PessoaCadastroDTO dto) throws ResourceNotFoundException {
		Integer id = this.pessoaService.create(dto);

		return this.pessoaService.findById(id);
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
