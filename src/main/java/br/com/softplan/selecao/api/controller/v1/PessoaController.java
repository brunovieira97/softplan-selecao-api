package br.com.softplan.selecao.api.controller.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.softplan.selecao.api.dto.v1.PessoaCadastroDTO;
import br.com.softplan.selecao.api.dto.v1.PessoaRetornoDTO;
import br.com.softplan.selecao.api.exception.ResourceNotFoundException;
import br.com.softplan.selecao.api.service.v1.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v1/pessoas")
@ApiResponses({
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content()),
	@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content())
})
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(
		summary = "Busca uma pessoa",
		description = "Retorna uma pessoa específica, com base no ID informado."
	)
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Sucesso"),
		@ApiResponse(responseCode = "204", description = "Pessoa com este ID não existe", content = @Content())
	})
	public PessoaRetornoDTO find(
		@Parameter(name = "id", description = "ID da Pessoa a ser retornada.", required = true)
		@PathVariable
			Integer id
	) throws ResourceNotFoundException {
		return this.pessoaService.findById(id);
	}

	@GetMapping
	@Operation(
		summary = "Listar pessoas",
		description = "Lista todas as pessoas cadastradas"
	)
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Sucesso"),
	})
	public List<PessoaRetornoDTO> findAll() {
		return pessoaService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(
		summary = "Cadastrar pessoa",
		description = "Cria um registro de Pessoa com os dados informados. Os dados são validados."
	)
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Pessoa criada"),
	})
	public PessoaRetornoDTO create(
		@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "DTO que representa a Pessoa a ser persistida."
		)
		@Parameter(required = true)
		@RequestBody
		@Valid
			PessoaCadastroDTO dto
	) throws ResourceNotFoundException {
		Integer id = this.pessoaService.create(dto);

		return this.pessoaService.findById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(
		summary = "Atualizar pessoa",
		description = "Atualiza um registro de pessoa já cadastrado, com os dados informados. Os dados são validados."
	)
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Sucesso"),
		@ApiResponse(responseCode = "204", description = "Pessoa com este ID não existe", content = @Content())
	})
	public void update(
		@Parameter(name = "id", description = "ID da Pessoa a ser atualizada")
		@PathVariable
			Integer id,
		@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "DTO que representa o objeto de Pessoa a persistir (com campos inalterados também)."
		)
		@Parameter(name = "dto", required = true)
		@RequestBody
		@Valid
			PessoaCadastroDTO dto
	) throws ResourceNotFoundException {
		this.pessoaService.update(id, dto);
	}

	
}
