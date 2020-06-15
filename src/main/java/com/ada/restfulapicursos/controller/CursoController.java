package com.ada.restfulapicursos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.restfulapicursos.model.Curso;
import com.ada.restfulapicursos.model.Empresa;
import com.ada.restfulapicursos.repository.CursoRepository;
import com.ada.restfulapicursos.repository.EmpresaRepository;

@Controller
@RequestMapping(path = "/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@PostMapping(path = "/add/{empresaId}")
	public ResponseEntity<Curso> addCurso(@PathVariable int empresaId, @RequestBody Curso curso) {
		Optional<Empresa> optEmpre = empresaRepository.findById(empresaId);
		if (Optional.empty().equals(optEmpre)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			
			Empresa empresa = optEmpre.get();
			curso.setEmpresa(empresa);
			cursoRepository.save(curso);
			return new ResponseEntity<>(curso, HttpStatus.CREATED);
		}
	}
	
	@GetMapping(path = "/get")
	public ResponseEntity<Curso> getCurso(@RequestParam int id){
		Curso curso = cursoRepository.findById(id);
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}
	
}
