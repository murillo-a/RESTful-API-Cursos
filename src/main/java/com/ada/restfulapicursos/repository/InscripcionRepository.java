package com.ada.restfulapicursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.Inscripcion;

public interface InscripcionRepository extends CrudRepository<Inscripcion, Integer> {

	public Inscripcion findById(int id);
}
