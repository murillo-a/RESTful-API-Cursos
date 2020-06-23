package com.ada.restfulapicursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.enums.RolNombre;
import com.ada.restfulapicursos.model.Rol;

public interface RolRepository extends CrudRepository<Rol, Long>{

	public Rol findByRolNombre(RolNombre rolNombre);
	
}
