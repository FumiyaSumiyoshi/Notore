package com.notore.springboot.front.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.front.repositories.LevelsRepositoryFront;
import com.notore.springboot.model.Levels;

/**
 * レベル管理のためのサービスクラス(フロント用)
 */
@Service
public class LevelsServiceFront {

	@Autowired
	LevelsRepositoryFront levelsRepository;

	/**
	 * データを全件取得するメソッド
	 * @return
	 */
	public List<Levels> findAll() {

		return (List<Levels>) levelsRepository.findAll();

	}

	/**
	 * IDによって絞り込むためのメソッド
	 * @param name
	 * @return
	 */
	public Optional<Levels> findById(Long name) {

		return levelsRepository.findById((name));

	}

}
