package com.algaworks.algamoneyapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * Evento que atende a criação da location no header de resposta
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 17/09/2017 15:30:16
 */
public class ResourceSaveEvent extends ApplicationEvent {

	/**
	 * Atributo de serialização
	 */
	private static final long serialVersionUID = 6626776095119959380L;

	/**
	 * HttpServletResponse resposta
	 */
	private HttpServletResponse response;

	/**
	 * codigo da entidade
	 */
	private Long code;

	/**
	 * Construtor
	 *
	 * @param source
	 * @param response
	 * @param code
	 */
	public ResourceSaveEvent(Object source, HttpServletResponse response, Long code) {
		super(source);
		this.response = response;
		this.code = code;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

}
