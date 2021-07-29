package com.notore.springboot.admin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Administrator;

/**
 * 管理者情報管理のためのリポジトリインターフェース
 */
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

	public Optional<Administrator> findById(Long name);

}
