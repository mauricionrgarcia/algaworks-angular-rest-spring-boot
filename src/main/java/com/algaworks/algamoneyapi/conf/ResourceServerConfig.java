package com.algaworks.algamoneyapi.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * Classe de configuração para autentificação local dos recursos
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 17/10/2017 20:30:42
 */
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/**
	 * @see
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ROLE");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/launches/**").permitAll().anyRequest().authenticated()
				.and().httpBasic()
				// não maanter sessão
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf()
				.disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.stateless(Boolean.TRUE);
	}

	/**
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * @return Handler para permitr fazer a segurança dos methdos como OAuth2
	 */
	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}

}
