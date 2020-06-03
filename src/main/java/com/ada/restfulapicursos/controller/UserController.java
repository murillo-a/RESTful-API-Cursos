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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.repository.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestBody User user) {
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/get")
	public ResponseEntity<User> getUser(@RequestParam Integer id) {
		Optional<User> optUser = userRepository.findById(id);
		if (optUser.equals(Optional.empty())) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		else {
		User user = optUser.get();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	}
	
}
