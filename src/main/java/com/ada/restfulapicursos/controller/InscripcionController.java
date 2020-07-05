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

import com.ada.restfulapicursos.dto.InscripDto;
import com.ada.restfulapicursos.model.Curso;
import com.ada.restfulapicursos.model.Inscripcion;
import com.ada.restfulapicursos.model.Participante;
import com.ada.restfulapicursos.repository.CursoRepository;
import com.ada.restfulapicursos.repository.InscripcionRepository;
import com.ada.restfulapicursos.repository.ParticipanteRepository;

@Controller
@RequestMapping(path = "/api")
public class InscripcionController {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping(path = "/inscripcion")
	public ResponseEntity<Inscripcion> addInscripcion(@RequestBody InscripDto inscripDto){
		
		Optional<Participante> optPart = participanteRepository.findById(inscripDto.getPartId());
		Participante participante = optPart.get();
		
		Curso curso = cursoRepository.findById(inscripDto.getCursoId());
		
		Inscripcion inscripcion = new Inscripcion(participante, curso, inscripDto.getPorcentPedido(), inscripDto.getEstado());
		
		inscripcionRepository.save(inscripcion);
		return new ResponseEntity<>(inscripcion, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/inscripcion")
	public ResponseEntity<Inscripcion> getInscripcion(@RequestParam int id){
		Inscripcion inscripcion = inscripcionRepository.findById(id);
		return new ResponseEntity<>(inscripcion, HttpStatus.OK);
	}
	
}