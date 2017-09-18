package com.algaworks.algamoneyapi.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algamoneyapi.event.ResourceSaveEvent;

/**
 * Listener que atende o avento {@link ResourceSaveEvent}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 17/09/2017 15:35:39
 */
@Component
public class ResourceSaveListener implements ApplicationListener<ResourceSaveEvent> {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.
	 * springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ResourceSaveEvent event) {

		HttpServletResponse response = event.getResponse();
		Long code = event.getCode();

		addHeaderLocation(response, code);
	}

	/**
	 * Adiciona o header Location do response
	 *
	 * @param response
	 * @param code
	 */
	private void addHeaderLocation(HttpServletResponse response, Long code) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(code).toUri();
		response.addHeader("Location", uri.toASCIIString());
	}

}
