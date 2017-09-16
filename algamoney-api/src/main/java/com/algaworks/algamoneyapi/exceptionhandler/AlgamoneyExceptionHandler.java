package com.algaworks.algamoneyapi.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algamoneyapi.util.BungleMessage;

/**
 * Intercepar exceção
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 00:51:50
 */
@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * recuperar as mensagens do arquivo messages.properties
	 */
	@Autowired
	private BungleMessage bungleMessage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.
	 * ResponseEntityExceptionHandler#handleHttpMessageNotReadable(org.
	 * springframework.http.converter.HttpMessageNotReadableException,
	 * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
	 * org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ResponseError erro = new ResponseError("Erro", HttpStatus.BAD_REQUEST.value(),
				String.valueOf(HttpStatus.BAD_REQUEST), bungleMessage.getMessage("invalid.request"),
				ex.getCause().toString());

		return handleExceptionInternal(ex, erro, headers, HttpStatus.BAD_REQUEST, request);
	}
}
