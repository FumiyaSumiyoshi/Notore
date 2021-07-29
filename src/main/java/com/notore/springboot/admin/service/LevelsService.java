package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.LevelsRepository;
import com.notore.springboot.model.Levels;

/**
 * レベル管理のためのサービスクラス
 */
@Service
public class LevelsService {

	@Autowired
	LevelsRepository levelsRepository;

	/**
	 * データを全件取得するメソッド
	 * @return
	 */
	public List<Levels> findAll() {

		return (List<Levels>) levelsRepository.findAll();

	}

	/**
	 * データを保存するメソッド
	 * @param levels
	 * @return
	 */
	public Levels saveAndFlush(Levels levels) {

		LocalDateTime date = LocalDateTime.now();

		levels.setCreateDate(date);
		levels.setUpdateDate(date);

		return levelsRepository.saveAndFlush(levels);

	}

	/**
	 * IDによって絞り込むためのメソッド
	 * @param name
	 * @return
	 */
	public Optional<Levels> findById(Long name) {

		return levelsRepository.findById((name));

	}

	/**
	 * 削除用メソッド
	 * @param levels
	 */
	public void delete(Levels levels) {

		levelsRepository.delete(levels);

	}

}
