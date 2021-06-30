package com.notore.springboot.front.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Levels;

@Repository
public interface LevelsRepository2 extends JpaRepository<Levels, Long> {
	
	public Optional<Levels> findById(Long name);
	
}
