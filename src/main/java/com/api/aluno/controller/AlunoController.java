package com.api.aluno.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.aluno.model.Aluno;
import com.api.aluno.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAllAluno() {		
		return ResponseEntity.ok().body(this.alunoService.getAllAluno());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable long id) {
		return ResponseEntity.ok().body(this.alunoService.getAlunoById(id));
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insertAluno(@Valid @RequestBody Aluno aluno) {
		return ResponseEntity.ok().body(this.alunoService.insertAluno(aluno));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable long id, @Valid @RequestBody Aluno aluno) {
		aluno.setId(id);
		return ResponseEntity.ok().body(this.alunoService.updateAluno(aluno));
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable long id) {		
		return ResponseEntity.ok().body(this.alunoService.deleteAluno(id));
	}
}