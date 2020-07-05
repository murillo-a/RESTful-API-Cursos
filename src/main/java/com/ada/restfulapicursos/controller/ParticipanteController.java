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

import com.ada.restfulapicursos.model.Participante;
import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.repository.ParticipanteRepository;
import com.ada.restfulapicursos.repository.UserRepository;

@Controller
@RequestMapping(path = "/api")
public class ParticipanteController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@PostMapping(path = "/participante/{userId}")
	public ResponseEntity<Participante> addParticipante(@PathVariable Long userId, @RequestBody Participante participante) {
		Optional<User> optUser = userRepository.findById(userId);

		if (Optional.empty().equals(optUser)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		} else {
			User user = optUser.get();
			participante.setUser(user);
			participanteRepository.save(participante);
			return new ResponseEntity<>(participante, HttpStatus.CREATED);
		}
	}

	@GetMapping(path = "/participante")
	public ResponseEntity<Participante> getParticipante(@RequestParam Long id) {
		Optional<Participante> optPart = participanteRepository.findById(id);
		if (Optional.empty().equals(optPart)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			Participante participante = optPart.get();
			return new ResponseEntity<>(participante, HttpStatus.OK);
		}

	}
}
