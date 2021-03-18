package br.com.softplan.selecao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.selecao.api.service.SourceService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/source")
public class SourceController {

	@Autowired
	private SourceService sourceService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(
		summary = "Buscar URL do repositório GitHub",
		description = "Retorna a URL do repositório deste projeto no GitHub."
	)
	public String getProjectUrl() {
		return this.sourceService.getProjectUrl();
	}
}
