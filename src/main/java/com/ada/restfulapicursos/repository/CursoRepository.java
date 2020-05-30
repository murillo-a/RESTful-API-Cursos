package com.ada.restfulapicursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer> {

	public Curso findById(int id);
	
}
