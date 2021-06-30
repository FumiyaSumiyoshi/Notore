package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.UserRepository;
import com.notore.springboot.model.User;


@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
	
	public List<User> findAll() {
		
		return(List<User>) userRepository.findAll();
		
	}
	
	public User saveAndFlush(User user) {
		
		LocalDateTime date = LocalDateTime.now();
		
		user.setAnswerDate(date);
		
		return  userRepository.saveAndFlush(user) ;
		
	}
	
	public Optional<User> findById(Long name) {
		
		return  userRepository.findById((name)) ;
		
	}
	
	public void delete(User user) {
		
		userRepository.delete(user) ;
		
	}
	

}
