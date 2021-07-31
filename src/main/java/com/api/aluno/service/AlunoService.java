package com.api.aluno.service;

import java.util.List;

import com.api.aluno.model.Aluno;

public interface AlunoService {
	
	List<Aluno> getAllAluno();
	
	Aluno getAlunoById(long id);
	
	Aluno insertAluno(Aluno aluno);
	
	Aluno updateAluno(Aluno aluno);
	
	Aluno deleteAluno(long id);

}