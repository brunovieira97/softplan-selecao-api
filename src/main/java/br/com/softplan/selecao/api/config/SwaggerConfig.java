package br.com.softplan.selecao.api.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	private static final String SCHEME_KEY = "httpBasic";
	
	private String groupedApiName = "softplan-selecao-api";

	private static final String
		INFO_TITLE = "Softplan - Manut. Pessoa",
		INFO_DESCRIPTION = "API de Manutenção de Pessoas, desenvolvida para o processo seletivo de Dev Java na Softplan",
		INFO_VERSION = "v1",
		INFO_CONTACT_NAME = "Bruno Vieira",
		INFO_CONTACT_URL = "https://github.com/brunovieira97",
		INFO_CONTACT_EMAIL = "bruno.vieira97@outlook.com";
	
	@Bean
	public GroupedOpenApi groupedOpenApi() {
		String[] packagesToScan = {"br.com.softplan.selecao.api.controller"};
		return GroupedOpenApi.builder()
			.group(groupedApiName)
			.pathsToMatch("/**")
			.packagesToScan(packagesToScan)
			.build();
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
			.addSecurityItem(new SecurityRequirement().addList(SCHEME_KEY, "global"))
			.info(this.getApiInfo())
			.components(new Components().addSecuritySchemes(SCHEME_KEY, this.getSecurityScheme()));
	}

	private SecurityScheme getSecurityScheme() {
		return new SecurityScheme()
			.type(SecurityScheme.Type.HTTP);
	}

	private Info getApiInfo() {
		return new Info()
			.title(INFO_TITLE)
			.description(INFO_DESCRIPTION)
			.version(INFO_VERSION)
			.contact(
				new Contact()
					.name(INFO_CONTACT_NAME)
					.email(INFO_CONTACT_EMAIL)
					.url(INFO_CONTACT_URL)
			);
	}
}
