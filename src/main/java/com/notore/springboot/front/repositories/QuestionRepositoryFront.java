package com.notore.springboot.front.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notore.springboot.model.Questions;

/**
 * 問題管理のためのリポジトリインターフェース(フロント用)
 */
@Repository
public interface QuestionRepositoryFront extends JpaRepository<Questions, Long> {

	public Questions[] findBylevelId(Long name);

	public Optional<Questions> findBylevelIdAndId(Long name, Long name2);

	public Questions[] findBylevelIdAndIdNotIn(Long name, List<Long> name2);

	public Questions[] findBylevelIdAndIdIn(Long name, List<Long> name2);

}
