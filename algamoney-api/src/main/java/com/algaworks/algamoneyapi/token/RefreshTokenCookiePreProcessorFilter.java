package com.algaworks.algamoneyapi.token;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * Intercepta a requisição para recuperar o access token do cookie
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 22/10/2017 14:51:18
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreProcessorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if ("/oauth/token".equalsIgnoreCase(httpRequest.getRequestURI())
				&& "refresh_token".equals(httpRequest.getParameter("grant_type")) && httpRequest.getCookies() != null) {
			for (Cookie cookie : httpRequest.getCookies()) {
				if ("refreshToken".equals(cookie.getName())) {
					String refreshToken = cookie.getValue();
					httpRequest = new MyServletRequestWrapper(httpRequest, refreshToken);
				}
			}
		}

		chain.doFilter(httpRequest, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	/**
	 * Wrapper para manipular a requisição
	 *
	 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
	 * @version
	 * @sinse 22/10/2017 14:58:18
	 */
	static class MyServletRequestWrapper extends HttpServletRequestWrapper {

		private String refreshToken;

		public MyServletRequestWrapper(HttpServletRequest request, String refreshToken) {
			super(request);
			this.refreshToken = refreshToken;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
			map.put("refresh_token", new String[] { refreshToken });
			map.setLocked(Boolean.TRUE);
			return map;
		}

	}
}
