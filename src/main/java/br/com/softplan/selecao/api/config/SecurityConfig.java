package br.com.softplan.selecao.api.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		final String[] DOCS_WHITELIST = {
			"/v3/api-docs/**",
            "/swagger-ui/**",
			"/swagger-ui.html"
		};

		httpSecurity
			.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers(HttpMethod.GET, "/source").permitAll()
				.antMatchers(DOCS_WHITELIST).permitAll()
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().cors();
	}
}
