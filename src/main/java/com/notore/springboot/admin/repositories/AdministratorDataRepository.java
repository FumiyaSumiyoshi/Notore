package com.notore.springboot.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.admin.model.AdministratorData;

@Repository
public interface AdministratorDataRepository extends JpaRepository<AdministratorData, Long> {

}
