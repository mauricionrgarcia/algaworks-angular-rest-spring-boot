package com.algaworks.algamoneyapi.exception;

/**
 * Exception generica da API
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 16/09/2017 01:21:42
 */
public class AlgamoneyException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -921775727443834374L;

	/**
	 * Representa o codigo do erro
	 */
	private String code;

	/**
	 * Representa a descrição da mensagem
	 */
	private String message;

	/**
	 * Descritivo da causa
	 */
	private String erroMessage;

	/**
	 * Construtor
	 */
	public AlgamoneyException() {
		super();
	}

	/**
	 * Construtor
	 *
	 * @param code codigo
	 */
	public AlgamoneyException(String code) {
		super(code);
	}

	/**
	 * Construtor
	 *
	 * @param code codigo do erro
	 * @param erroMessage mensagem
	 * @param cause causa
	 */
	public AlgamoneyException(String code, String message, String erroMessage) {
		super(code);
		this.code = code;
		this.message = message;
		this.erroMessage = erroMessage;
	}

	/**
	 * Construtor
	 *
	 * @param code codigo do erro
	 * @param erroMessage mensagem
	 * @param cause causa
	 * @param e Throwable
	 */
	public AlgamoneyException(String code, String message, String erroMessage, Throwable e) {
		super(code, e);
		this.code = code;
		this.message = message;
		this.erroMessage = erroMessage;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	@Override
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
	 * @return the erroMessage
	 */
	public String getErroMessage() {
		return erroMessage;
	}

	/**
	 * @param erroMessage the erroMessage to set
	 */
	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}

}
