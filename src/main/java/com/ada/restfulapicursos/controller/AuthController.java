package com.ada.restfulapicursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.restfulapicursos.dto.JwtDto;
import com.ada.restfulapicursos.dto.NuevoUser;
import com.ada.restfulapicursos.dto.UserLogin;
import com.ada.restfulapicursos.enums.RolNombre;
import com.ada.restfulapicursos.model.Rol;
import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.security.jwt.JwtProvider;
import com.ada.restfulapicursos.service.RolService;
import com.ada.restfulapicursos.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUser nuevoUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<String>("campos vacíos o email inválido", HttpStatus.BAD_REQUEST);
		}
		if (userService.existsByEmail(nuevoUser.getEmail())) {
			return new ResponseEntity<String>("ese email ya existe", HttpStatus.BAD_REQUEST);
		}
		User user = new User(nuevoUser.getNombre(), nuevoUser.getApellido(), nuevoUser.getEmail(),
				passwordEncoder.encode(nuevoUser.getPassword()));
		Set<String> rolesStr = nuevoUser.getRoles();
		Set<Rol> roles = new HashSet<>();
		for (String rol : rolesStr) {
			switch (rol) {
			case "admin":
				Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROL_ADMIN);
				roles.add(rolAdmin);
				break;
			case "part":
				Rol rolPart = rolService.getByRolNombre(RolNombre.ROL_PART);
				roles.add(rolPart);
				break;
			case "rep":
				Rol rolRep = rolService.getByRolNombre(RolNombre.ROL_REP);
				roles.add(rolRep);
				break;
			}
		}
		user.setRoles(roles);
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLogin loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<String>("campos vacíos o email inválido", HttpStatus.BAD_REQUEST);
		}
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDTO = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<JwtDto>(jwtDTO, HttpStatus.OK);
	}
}