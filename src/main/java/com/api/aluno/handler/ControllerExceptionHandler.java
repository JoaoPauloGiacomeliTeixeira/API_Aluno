package com.api.aluno.handler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.aluno.exception.NotFoundAlunoException;
import com.api.aluno.exception.UpdateAlunoException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UpdateAlunoException.class)
	public ResponseEntity<?> runtimeException(UpdateAlunoException e, WebRequest request){
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Atualização inválida");
        body.put("message", e.getMessage());
        
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);	
	}
	
	@ExceptionHandler(NotFoundAlunoException.class)
	public ResponseEntity<?> notFoundAlunoException(NotFoundAlunoException e, WebRequest request){
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Aluno inválido");
        body.put("message", e.getMessage());
        
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
		List<String> messages = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", "Conflito de Dados");
        body.put("message", messages);

		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);	
	}
	
}