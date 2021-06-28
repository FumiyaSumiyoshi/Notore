package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.AdministratorRepository;
import com.notore.springboot.model.Administrator;


@Service
public class AdminService {
	
	@Autowired
    AdministratorRepository adminRepository;
	
	public List<Administrator> findAll() {
		
		return(List<Administrator>) adminRepository.findAll();
		
	}
	
	public Administrator saveAndFlush(Administrator administrator) {
		
		LocalDateTime date = LocalDateTime.now();
		
		administrator.setCreateDate(date);
		administrator.setUpdateDate(date);
		
		return  adminRepository.saveAndFlush(administrator) ;
		
	}
	
	public Optional<Administrator> findById(Long name) {
		
		return  adminRepository.findById((name)) ;
		
	}
	
	public void delete(Administrator administrator) {
		
		adminRepository.delete(administrator) ;
		
	}
	

}
