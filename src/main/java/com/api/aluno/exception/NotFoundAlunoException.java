package com.api.aluno.exception;

public class NotFoundAlunoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundAlunoException(String message) {
		super(message);
	}
	
	public NotFoundAlunoException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
