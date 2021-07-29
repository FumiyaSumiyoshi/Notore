package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.CategoryRepository;
import com.notore.springboot.model.Categories;

/**
 * カテゴリ管理のためのサービスクラス
 */
@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * データを全件取得するメソッド
	 * @return
	 */
	public List<Categories> findAll() {

		return (List<Categories>) categoryRepository.findAll();

	}

	/**
	 * データを保存するメソッド
	 * @param categories
	 * @return
	 */
	public Categories saveAndFlush(Categories categories) {

		LocalDateTime date = LocalDateTime.now();

		categories.setCreateDate(date);
		categories.setUpdateDate(date);

		return categoryRepository.saveAndFlush(categories);

	}

	/**
	 * IDによって絞り込むためのメソッド
	 * @param name
	 * @return
	 */
	public Optional<Categories> findById(Long name) {

		return categoryRepository.findById((name));

	}

	/**
	 * 削除用メソッド
	 * @param categories
	 */
	public void delete(Categories categories) {

		categoryRepository.delete(categories);

	}

}
