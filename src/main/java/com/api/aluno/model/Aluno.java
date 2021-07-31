package com.api.aluno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Aluno {	
	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty(message = "O nome do aluno deve ser preenchido.")
	@Size(min = 1, max = 50, message = "O nome do aluno deve conter entre 1 e 50 letras.")
	private String nome;
	
	@Max(value = 100, message = "A idade máxima permitida é de 100 anos.")
	private int idade;	
}