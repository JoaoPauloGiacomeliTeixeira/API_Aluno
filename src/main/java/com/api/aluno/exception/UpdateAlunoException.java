package com.api.aluno.exception;

public class UpdateAlunoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UpdateAlunoException(String message) {
		super(message);
	}
	
	public UpdateAlunoException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
