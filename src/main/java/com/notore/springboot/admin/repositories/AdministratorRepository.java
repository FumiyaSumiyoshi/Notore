package com.notore.springboot.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	
}
