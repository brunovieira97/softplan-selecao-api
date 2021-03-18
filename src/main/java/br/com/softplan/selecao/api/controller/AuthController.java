package br.com.softplan.selecao.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/auth")
@ApiResponses({
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content()),
	@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
})
public class AuthController {
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(
		summary = "Autenticar usuário",
		description =
			"Endpoint dummy criado para a validação de autenticação pelo front-end."
			+ "Serve apenas como um local fixo para o envio do header HTTP Basic e a validação de retorno 200."
	)
	@ApiResponse(responseCode = "200", description = "Autenticado", content = @Content())
	public void authenticate() {
		return;
	}
}
