package com.algaworks.algamoneyapi.exception;

/**
 * RuntimeExcpetion lançada quando é solicitado uma pessoa ativa
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 23/09/2017 12:44:44
 */
public class NonExistentActivePersonException extends AlgamoneyHandlerException {

	/**
	 * Mensagem default
	 */
	private static final String NON_EXISTENT_ACTIVE_PERSON = "non.existent.active.person.exception";

	/**
	 * @param message
	 */
	public NonExistentActivePersonException(String message) {
		super(message);
	}

	/**
	 * withDefaltMessage
	 */
	public NonExistentActivePersonException() {
		super(NON_EXISTENT_ACTIVE_PERSON);
	}

	/**
	 * Serialização
	 */
	private static final long serialVersionUID = -7704223434239636279L;

}
