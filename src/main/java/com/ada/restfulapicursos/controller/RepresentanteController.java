package com.ada.restfulapicursos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.restfulapicursos.form.RepForm;
import com.ada.restfulapicursos.model.Representante;
import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.repository.RepresentanteRepository;
import com.ada.restfulapicursos.repository.UserRepository;

@Controller
@RequestMapping(path = "/representante")
public class RepresentanteController {

	@Autowired
	private RepresentanteRepository representanteRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public ResponseEntity<Representante> addRepresentante(@RequestBody RepForm repForm) {
		User user;
		Representante representante = new Representante();
		int userId = repForm.getUserId();
		Optional<User> optUser = userRepository.findById(userId);
		
			if (Optional.empty().equals(optUser)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			user = optUser.get();
			representante.setUser(user);
			representante.setCargoEnEmpresa(repForm.getCargo());
			representante.setNroDeDoc(repForm.getNroDoc());
			representante.setTipoDeDoc(repForm.getTipoDoc());
			representanteRepository.save(representante);

			return new ResponseEntity<>(representante, HttpStatus.CREATED);
		}
	}

}
