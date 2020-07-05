package com.ada.restfulapicursos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.Curso;
import com.ada.restfulapicursos.model.Empresa;

public interface CursoRepository extends CrudRepository<Curso, Long> {

	public Optional<Curso> findById(Long id);
	
	public Iterable<Curso> findByCuposGreaterThan(int num);
	
	public Iterable<Curso> findByCategoria(String categoria);
	
	public Iterable<Curso> findByEmpresa(Empresa empresa);
	
	public Iterable<Curso> findByEmpresaAndCategoria(Empresa empresa, String categoria);
}
