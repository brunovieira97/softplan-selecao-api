package br.com.softplan.selecao.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
	@Bean
	@Primary
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource urlSource = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration corsConfig = new CorsConfiguration();

		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedOrigin("http://localhost");
		corsConfig.addAllowedHeader("*");
		
		corsConfig.addAllowedMethod("OPTIONS");
		corsConfig.addAllowedMethod("HEAD");
		corsConfig.addAllowedMethod("GET");
		corsConfig.addAllowedMethod("PUT");
		corsConfig.addAllowedMethod("POST");
		corsConfig.addAllowedMethod("DELETE");
		corsConfig.addAllowedMethod("PATCH");
		
		urlSource.registerCorsConfiguration("/**", corsConfig);
		
		return new CorsFilter(urlSource);
	}
}
