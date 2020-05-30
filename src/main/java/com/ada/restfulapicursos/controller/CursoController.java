package com.ada.restfulapicursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restfulapicursos.model.Curso;
import com.ada.restfulapicursos.repository.CursoRepository;

@Controller
@RequestMapping(path="/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addCurso(@RequestBody Curso curso) {
		cursoRepository.save(curso);
		return "Curso agregado";
	}
	
}
