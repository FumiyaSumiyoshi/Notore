package com.notore.springboot.admin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
	
	public Optional<Questions> findById(Long name);
	
}
