package br.com.softplan.selecao.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -6358496429312217988L;
	
}
