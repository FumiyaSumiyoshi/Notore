package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.QuestionRepository;
import com.notore.springboot.model.Questions;


@Service
public class QuestionService {
	
	@Autowired
    QuestionRepository questionRepository;
	
	public List<Questions> findAll() {
		
		return(List<Questions>) questionRepository.findAll();
		
	}
	
	public Questions saveAndFlush(Questions questions) {
		
		LocalDateTime date = LocalDateTime.now();
		
		questions.setCreateDate(date);
		questions.setUpdateDate(date);
		
		return  questionRepository.saveAndFlush(questions) ;
		
	}
	
	public Optional<Questions> findById(Long name) {
		
		return  questionRepository.findById((name)) ;
		
	}
	
	public void delete(Questions questions) {
		
		questionRepository.delete(questions) ;
		
	}
	

}
