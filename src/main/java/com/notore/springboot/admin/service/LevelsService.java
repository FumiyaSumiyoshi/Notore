package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.LevelsRepository;
import com.notore.springboot.model.Levels;


@Service
public class LevelsService {
	
	@Autowired
    LevelsRepository levelsRepository;
	
	public List<Levels> findAll() {
		
		return(List<Levels>) levelsRepository.findAll();
		
	}
	
	public Levels saveAndFlush(Levels levels) {
		
		LocalDateTime date = LocalDateTime.now();
		
		levels.setCreateDate(date);
		levels.setUpdateDate(date);
		
		return  levelsRepository.saveAndFlush(levels) ;
		
	}
	
	public Optional<Levels> findById(Long name) {
		
		return  levelsRepository.findById((name)) ;
		
	}
	
	public void delete(Levels levels) {
		
		levelsRepository.delete(levels) ;
		
	}
	

}
