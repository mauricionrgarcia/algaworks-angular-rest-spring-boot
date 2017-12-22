package com.algaworks.algamoneyapi.conf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuração de segurança basicadefinida por meio de profile ativo
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 21/12/2017 21:45:33
 */
@Profile("disable-security")
@EnableWebSecurity
public class DisableSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
	}

}
