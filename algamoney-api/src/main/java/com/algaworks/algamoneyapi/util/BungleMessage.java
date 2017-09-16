package com.algaworks.algamoneyapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Classe utilitaria para encapsular as chamadas para o arquivo de mensagens do
 * {@link MessageSource}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 01:08:31
 */
@Service
public class BungleMessage {

	/**
	 * recuperar as mensagens do arquivo messages.properties
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Encapsunas as mensagens
	 *
	 * @param message codigo da mensagem
	 * @param args parametros
	 * @return mensagem
	 */
	public String getMessage(String message, Object... args) {
		return messageSource.getMessage(message, args, LocaleContextHolder.getLocale());
	}

}
