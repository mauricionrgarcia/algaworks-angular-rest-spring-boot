package com.algaworks.algamoneyapi.exception;

/**
 * RuntimeExcpetion lançada quando é solicitado uma pessoa ativa
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 23/09/2017 12:44:44
 */
public class AlgamoneyHandlerException extends RuntimeException {

	/**
	 * Serialização
	 */
	private static final long serialVersionUID = -7704223434239636279L;

	/**
	 * @param message
	 */
	public AlgamoneyHandlerException(String message) {
		super(message);
	}

}
