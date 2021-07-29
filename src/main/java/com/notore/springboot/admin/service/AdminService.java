package com.notore.springboot.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.AdministratorRepository;
import com.notore.springboot.model.Administrator;

/**
 * 管理者情報管理のためのサービスクラス
 */
@Service
public class AdminService {

	@Autowired
	AdministratorRepository adminRepository;

	/**
	 * データを全件取得するメソッド
	 * @return
	 */
	public List<Administrator> findAll() {

		return (List<Administrator>) adminRepository.findAll();

	}

	/**
	 * データを保存するメソッド
	 * @param administrator
	 * @return
	 */
	public Administrator saveAndFlush(Administrator administrator) {

		LocalDateTime date = LocalDateTime.now();

		administrator.setCreateDate(date);
		administrator.setUpdateDate(date);

		return adminRepository.saveAndFlush(administrator);

	}

	/**
	 * IDによって絞り込むためのメソッド
	 * @param name
	 * @return
	 */
	public Optional<Administrator> findById(Long name) {

		return adminRepository.findById((name));

	}

	/**
	 * 削除用メソッド
	 * @param administrator
	 */
	public void delete(Administrator administrator) {

		adminRepository.delete(administrator);

	}

}
