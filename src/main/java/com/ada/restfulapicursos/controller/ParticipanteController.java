package com.ada.restfulapicursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ada.restfulapicursos.repository.ParticipanteRepository;

@Controller
@RequestMapping(path = "/participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	
	
}
