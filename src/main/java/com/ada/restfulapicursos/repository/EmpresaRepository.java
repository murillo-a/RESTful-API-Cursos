package com.ada.restfulapicursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
