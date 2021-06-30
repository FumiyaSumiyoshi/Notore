package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.CategoryRepository;
import com.notore.springboot.model.Categories;


@Service
public class CategoryService {
	
	@Autowired
    CategoryRepository categoryRepository;
	
	public List<Categories> findAll() {
		
		return(List<Categories>) categoryRepository.findAll();
		
	}
	
	public Categories saveAndFlush(Categories categories) {
		
		LocalDateTime date = LocalDateTime.now();
		
		categories.setCreateDate(date);
		categories.setUpdateDate(date);
		
		return  categoryRepository.saveAndFlush(categories) ;
		
	}
	
	public Optional<Categories> findById(Long name) {
		
		return  categoryRepository.findById((name)) ;
		
	}
	
	public void delete(Categories categories) {
		
		categoryRepository.delete(categories) ;
		
	}
	

}
