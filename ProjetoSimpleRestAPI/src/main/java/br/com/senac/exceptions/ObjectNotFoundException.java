package br.com.senac.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(String messagem, Throwable cause) {
		super(messagem,cause);
	}
	
	public ObjectNotFoundException(String messagem) {
		super(messagem);
	}
	
}
