package com.notore.springboot.admin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
	
	public Optional<Categories> findById(Long name);
	
}
