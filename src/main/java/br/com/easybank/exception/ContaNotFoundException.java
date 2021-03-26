package br.com.easybank.exception;

public class ContaNotFoundException extends RuntimeException{
	public ContaNotFoundException(String message) {
		super(message);
	}
}
