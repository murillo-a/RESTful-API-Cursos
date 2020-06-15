package com.ada.restfulapicursos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.Representante;

public interface RepresentanteRepository extends CrudRepository<Representante, Integer> {

	public Optional<Representante> findByRepId(Integer repId);
	
}
