package com.notore.springboot.front.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.front.repositories.QuestionRepositoryFront;
import com.notore.springboot.model.Questions;

/**
 * 問題管理のためのサービスクラス(フロント用)
 */
@Service
public class QuestionServiceFront {

	@Autowired
	QuestionRepositoryFront questionRepository;

	/**
	 * レベルIDによって絞り込むためのメソッド
	 * @param name
	 * @return
	 */
	public Questions[] findBylevelId(Long name) {

		return questionRepository.findBylevelId((name));

	}

	/**
	 * IDとレベルIDによって絞り込むためのメソッド
	 * @param name
	 * @param name2
	 * @return
	 */
	public Optional<Questions> findBylevelIdAndId(Long name, Long name2) {

		return questionRepository.findBylevelIdAndId((name), (name2));

	}

	/**
	 * IDがリストに入っていない上で, レベルIDによって絞り込むためのメソッド
	 * @param name
	 * @param name2
	 * @return
	 */
	public Questions[] findBylevelIdAndIdNotIn(Long name, List<Long> name2) {

		return questionRepository.findBylevelIdAndIdNotIn((name), (name2));

	}

	/**
	 * IDがリストに入っている上で, レベルIDによって絞り込むためのメソッド
	 * @param name
	 * @param name2
	 * @return
	 */
	public Questions[] findBylevelIdAndIdIn(Long name, List<Long> name2) {

		return questionRepository.findBylevelIdAndIdIn((name), (name2));

	}

}
