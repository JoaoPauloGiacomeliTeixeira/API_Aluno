package com.api.aluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.aluno.exception.NotFoundAlunoException;
import com.api.aluno.exception.UpdateAlunoException;
import com.api.aluno.model.Aluno;
import com.api.aluno.repository.AlunoRepository;

@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public List<Aluno> getAllAluno() {		
		return this.alunoRepository.findAll();
	}

	@Override
	public Aluno getAlunoById(long id) {
		Optional<Aluno> aluno = this.alunoRepository.findById(id);
		
		if (aluno.isPresent()) {
			return aluno.get();
		} else {
			throw new NotFoundAlunoException("Aluno não encontrado, id:" + id);
		}	
	}

	@Override
	public Aluno insertAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno updateAluno(Aluno aluno) {
		Optional<Aluno> alunoDb = this.alunoRepository.findById(aluno.getId());
		
		if (alunoDb.isPresent()) {			
			return alunoRepository.save(aluno);
		} else {
			throw new UpdateAlunoException("Aluno inexistente para atualização de dados, id:" + aluno.getId());
		}		
	}

	@Override
	public Aluno deleteAluno(long id) {
		Optional<Aluno> aluno = this.alunoRepository.findById(id);
		
		this.alunoRepository.delete(aluno.get());
		
		return aluno.get();
	}

}