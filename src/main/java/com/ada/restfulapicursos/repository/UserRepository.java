package com.ada.restfulapicursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String email);

	boolean existsByEmail(String email);

}