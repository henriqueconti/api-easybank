package br.com.easybank.exception;

public class ClienteNotFoundException extends RuntimeException{
	public ClienteNotFoundException(String message) {
		super(message);
	}
}
