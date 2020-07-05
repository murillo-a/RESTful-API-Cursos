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

import com.ada.restfulapicursos.model.Representante;
import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.repository.RepresentanteRepository;
import com.ada.restfulapicursos.repository.UserRepository;

@Controller
@RequestMapping(path = "/api")
public class RepresentanteController {

	@Autowired
	private RepresentanteRepository representanteRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/representante/{userId}")
	public ResponseEntity<Representante> addRepresentante(@PathVariable Long userId, @RequestBody Representante representante) {
		Optional<User> optUser = userRepository.findById(userId);
		if (Optional.empty().equals(optUser)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			User user;
			user = optUser.get();
			representante.setUser(user);
			representanteRepository.save(representante);
			return new ResponseEntity<>(representante, HttpStatus.CREATED);
		}
	}

	@GetMapping(path = "/representante")
	public ResponseEntity<Representante> getRepresentante(@RequestParam Long id) {		
		Optional<Representante> optRep = representanteRepository.findByRepId(id);
		if (Optional.empty().equals(optRep)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			Representante representante = optRep.get();
			return new ResponseEntity<>(representante, HttpStatus.OK);
		}
	}

}
