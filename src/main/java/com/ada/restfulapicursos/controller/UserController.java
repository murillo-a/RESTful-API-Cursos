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

import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.repository.UserRepository;

@Controller
@RequestMapping(path = "/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/users")
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> users = userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping(path = "/user")
	public ResponseEntity<User> getUser(@RequestParam Long id) {
		Optional<User> optUser = userRepository.findById(id);
		if (Optional.empty().equals(optUser)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			User user = optUser.get();
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

}
