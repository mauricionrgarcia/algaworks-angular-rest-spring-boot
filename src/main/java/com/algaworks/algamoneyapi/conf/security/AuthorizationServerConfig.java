package com.algaworks.algamoneyapi.conf.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.algaworks.algamoneyapi.conf.token.CustomTokenEnhacer;

/**
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 17/10/2017 22:35:05
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	/**
	 * gerencia a autenticação
	 */
	@Autowired
	public AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("angular").secret("1234").scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")// password flow - client recebe user/psw to recover
																	// token
				.accessTokenValiditySeconds(300).refreshTokenValiditySeconds(3600 * 24).and().withClient("mobile")
				.secret("mobile").scopes("read").authorizedGrantTypes("password", "refresh_token")// password flow -
																									// client recebe
																									// user/psw to
																									// recover token
				.accessTokenValiditySeconds(300).refreshTokenValiditySeconds(3600 * 24);

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));

		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain).reuseRefreshTokens(Boolean.FALSE)
				.authenticationManager(authenticationManager);

	}

	/**
	 * @return {@link TokenEnhancer} adicionando funcioalidade ao token
	 */
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhacer();
	}

	/**
	 * Conversor token
	 *
	 * @return
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("algaworks");
		return converter;
	}

	/**
	 * @return token recuperado inMemory
	 */
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

}
