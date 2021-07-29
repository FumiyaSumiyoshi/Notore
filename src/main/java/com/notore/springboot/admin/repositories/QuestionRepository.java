package com.notore.springboot.admin.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Questions;

/**
 * 問題管理のためのリポジトリインターフェース
 */
@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {

	public Optional<Questions> findById(Long name);

	public Page<Questions> findAll(Pageable pageable);

}
