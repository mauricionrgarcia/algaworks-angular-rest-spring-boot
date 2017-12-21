package com.algaworks.algamoneyapi.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.algaworks.algamoneyapi.conf.property.AlgamoneyAPIProperty;

/**
 * Intercepta a requisição do token para remover o refresh_token do json de
 * respota e adicona o mesmo no cookie
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 22/10/2017 14:04:28
 */
@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

	@Autowired
	private transient AlgamoneyAPIProperty property;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return returnType.getMember().getName().equals("postAccessToken");
	}

	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {

		HttpServletRequest httpRequest = ((ServletServerHttpRequest) request).getServletRequest();
		HttpServletResponse httpResponse = ((ServletServerHttpResponse) response).getServletResponse();

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;

		String refreshToken = body.getRefreshToken().getValue();
		addRefreshTokenInCookie(refreshToken, httpRequest, httpResponse);
		removeRefreshTokenBody(token);

		return token;
	}

	/**
	 * remove o atributo refreshToken do objeto de retorno
	 *
	 * @param token
	 */
	private void removeRefreshTokenBody(DefaultOAuth2AccessToken token) {
		token.setRefreshToken(null);
	}

	/**
	 * Adiciona o refreshToken para o cookie
	 *
	 * @param refreshToken
	 * @param httpRequest
	 * @param httpResponse
	 */
	private void addRefreshTokenInCookie(String refreshToken, HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {

		Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
		refreshTokenCookie.setHttpOnly(Boolean.TRUE);
		refreshTokenCookie.setSecure(property.getSecurity().getEnagleHttps());
		refreshTokenCookie.setPath(httpRequest.getContextPath() + "/oauth/token");
		refreshTokenCookie.setMaxAge(2592000);
		httpResponse.addCookie(refreshTokenCookie);

	}

}
