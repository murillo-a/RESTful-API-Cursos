package com.ada.restfulapicursos.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ada.restfulapicursos.model.User;


public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmail(String email);
	
	public Optional<User> findById(Long id);

	public boolean existsByEmail(String email);

}