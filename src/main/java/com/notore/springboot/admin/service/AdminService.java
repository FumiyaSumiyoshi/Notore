package com.notore.springboot.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.AdministratorRepository;
import com.notore.springboot.model.Administrator;


@Service
public class AdminService {
	
	@Autowired
    AdministratorRepository adminRepository;
	
//	public Iterable<Administrator> findAll() {
//		
//		Iterable<Administrator> list = adminRepository.findAll();
//		
//		return list;
//		
//	}
	
	public List<Administrator> findAll() {
		
		List<Administrator> adminlist = adminRepository.findAll();
		
		return adminlist;
		
	}
	
}
