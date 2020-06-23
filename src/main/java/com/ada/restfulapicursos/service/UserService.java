package com.ada.restfulapicursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restfulapicursos.model.User;
import com.ada.restfulapicursos.repository.UserRepository;

@Service
@Transactional
public class UserService {

	    @Autowired
	    UserRepository userRepository;

	    public boolean existsByEmail(String email){
	        return userRepository.existsByEmail(email);
	    }

	    public User getByEmail(String email){
	        return userRepository.findByEmail(email);
	    }
	    
	    public void save(User user){
	        userRepository.save(user);
	    }
	}
