package com.algaworks.algamoneyapi.exceptionhandler;

import java.io.Serializable;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Atende ao detalhamento dos erros
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 01:28:43
 */
@JsonInclude(Include.NON_NULL)
public class ResponseError implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7086555032131362215L;

	/**
	 * titulo erro
	 */
	private String title;

	/**
	 * representa o status code
	 */
	private Integer status;

	/**
	 * representa o codigo do erro
	 */
	private String errorCode;

	/**
	 * representa a mensagen de erro
	 */
	private String message;

	/**
	 * representa a mensagen de erro para o desenvolvedor
	 */
	private String errorMessage;

	/**
	 * representa o horario
	 */
	private Long timestamp;

	/**
	 * Construtor:
	 *
	 * @param title
	 * @param status
	 * @param errorCode
	 * @param message
	 * @param errorMessage
	 */
	public ResponseError(String title, Integer status, String errorCode, String message, String errorMessage) {
		super();
		this.title = title;
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
		this.errorMessage = errorMessage;
		timestamp = Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
