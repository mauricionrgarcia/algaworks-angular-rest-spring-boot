package com.algaworks.algamoneyapi.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algamoneyapi.exception.AlgamoneyHandlerException;
import com.algaworks.algamoneyapi.util.BundleMessage;

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
	private BundleMessage bungleMessage;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.web.servRlet.mvc.method.annotation.
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
				ex.getCause() == null ? ex.toString() : ex.getCause().toString());

		return handleExceptionInternal(ex, erro, headers, HttpStatus.BAD_REQUEST, request);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.web.servlet.mvc.method.annotation.
	 * ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.
	 * springframework.web.bind.MethodArgumentNotValidException,
	 * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
	 * org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleExceptionInternal(ex, creteRespondeError(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST,
				request);
	}

	/**
	 * Trata exceção de recurso nao encontrado
	 *
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	protected ResponseEntity<Object> handleEmptyResultDataAccessException(Exception ex, WebRequest request) {
		ResponseError responseError = new ResponseError("Erro", HttpStatus.NOT_FOUND.value(),
				String.valueOf(HttpStatus.NOT_FOUND), bungleMessage.getMessage("resource.not.found"), ex.toString());

		return handleExceptionInternal(ex, Arrays.asList(responseError), new HttpHeaders(), HttpStatus.NOT_FOUND,
				request);
	}

	/**
	 * Trata exceção de recurso nao encontrado validação de contrains violation
	 *
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ DataIntegrityViolationException.class })
	protected ResponseEntity<Object> handleDataIntegrityViolationException(Exception ex, WebRequest request) {
		ResponseError responseError = new ResponseError("Erro", HttpStatus.BAD_REQUEST.value(),
				String.valueOf(HttpStatus.BAD_REQUEST), bungleMessage.getMessage("resource.not.found"),
				ExceptionUtils.getRootCauseMessage(ex));

		return handleExceptionInternal(ex, Arrays.asList(responseError), new HttpHeaders(), HttpStatus.NOT_FOUND,
				request);
	}

	/**
	 * Trata exceção de regras de negocio
	 *
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ AlgamoneyHandlerException.class })
	protected ResponseEntity<Object> handleAlgamoneyHandlerException(AlgamoneyHandlerException ex, WebRequest request) {
		ResponseError responseError = new ResponseError("Erro", HttpStatus.BAD_REQUEST.value(),
				String.valueOf(HttpStatus.BAD_REQUEST), bungleMessage.getMessage(ex.getMessage()),
				ExceptionUtils.getRootCauseMessage(ex));

		return handleExceptionInternal(ex, Arrays.asList(responseError), new HttpHeaders(), HttpStatus.NOT_FOUND,
				request);
	}

	/**
	 * Prepara a lista de erros atravez da validação dos campos
	 *
	 * @param bindingResult {@link BindingResult}
	 * @return {@link List} {@link ResponseError}
	 */
	private List<ResponseError> creteRespondeError(BindingResult bindingResult) {
		List<ResponseError> errors = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			errors.add(new ResponseError("Erro", HttpStatus.BAD_REQUEST.value(), String.valueOf(HttpStatus.BAD_REQUEST),
					bungleMessage.getMessage(fieldError), fieldError.toString()));
		}
		return errors;

	}
}
