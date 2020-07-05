package com.ada.restfulapicursos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.restfulapicursos.model.Empresa;
import com.ada.restfulapicursos.model.Representante;
import com.ada.restfulapicursos.repository.EmpresaRepository;
import com.ada.restfulapicursos.repository.RepresentanteRepository;

@Controller
@RequestMapping(path = "/api")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private RepresentanteRepository representanteRepository;

	@PostMapping(path = "/empresa")
	//TODO cursos-add aprobacion de admin antes de dar de alta a la empresa
	public ResponseEntity<Empresa> addEmpresa(@RequestParam Long repId, @RequestBody Empresa empresa) {
		Optional<Representante> optRep = representanteRepository.findById(repId);
		if (Optional.empty().equals(optRep)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			Representante representante = optRep.get();
			empresa.setRepresentante(representante);
			empresaRepository.save(empresa);
			return new ResponseEntity<>(empresa, HttpStatus.CREATED);
		}
	}

	@GetMapping(path = "/empresa")
	public ResponseEntity<Empresa> getEmpresa(@RequestParam int id){
		Empresa empresa = empresaRepository.findById(id);
		if (empresa.equals(null)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
		return new ResponseEntity<>(empresa, HttpStatus.OK);
		}
	}
	
	
	
}
