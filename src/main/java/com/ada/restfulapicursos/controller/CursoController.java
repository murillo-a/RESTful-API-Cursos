package com.ada.restfulapicursos.controller;

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
		Empresa empresa = empresaRepository.findById(empresaId);
		if (empresa.equals(null)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			curso.setEmpresa(empresa);
			cursoRepository.save(curso);
			return new ResponseEntity<>(curso, HttpStatus.CREATED);
		}
	}

	@GetMapping(path = "/get")
	public ResponseEntity<Curso> getCurso(@RequestParam int id) {
		Curso curso = cursoRepository.findById(id);
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}

	@GetMapping(path = "/disponibles")
	public ResponseEntity<Iterable<Curso>> getCursosDisponibles() {
		Iterable<Curso> cursos = cursoRepository.findByCuposGreaterThan(0);
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}

	@GetMapping(path = "/porcategoria/{cat}")
	public ResponseEntity<Iterable<Curso>> findByCategoria(@PathVariable String cat) {
		Iterable<Curso> cursos = cursoRepository.findByCategoria(cat);
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	
	@GetMapping(path = "/porempresa/{empresaNom}")
	public ResponseEntity<Iterable<Curso>> findByEmpresa(@PathVariable String empresaNom) {
		Empresa empresa = empresaRepository.findByNombreIgnoreCase(empresaNom);
		
		Iterable<Curso> cursos = cursoRepository.findByEmpresa(empresa);
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{empresaNom}/{cat}")
	public ResponseEntity<Iterable<Curso>> findByEmpCat(@PathVariable String empresaNom, @PathVariable String cat) {
		Empresa empresa = empresaRepository.findByNombreIgnoreCase(empresaNom);
		
		Iterable<Curso> cursos = cursoRepository.findByEmpresaAndCategoria(empresa, cat);
		return new ResponseEntity<>(cursos, HttpStatus.OK);
	}
	
}
