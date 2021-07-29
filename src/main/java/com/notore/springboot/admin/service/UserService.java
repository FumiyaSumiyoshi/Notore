package com.notore.springboot.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notore.springboot.admin.repositories.UserRepository;
import com.notore.springboot.model.User;

/**
 * ユーザー情報管理のためのサービスクラス
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * データを全件取得するメソッド
	 * @return
	 */
	public List<User> findAll() {

		return (List<User>) userRepository.findAll();

	}

	/**
	 * データを保存するメソッド
	 * @param user
	 * @return
	 */
	public User saveAndFlush(User user) {

		return userRepository.saveAndFlush(user);

	}

	/**
	 * IDによって絞り込むためのメソッド
	 * @param name
	 * @return
	 */
	public Optional<User> findById(Long name) {

		return userRepository.findById((name));

	}

	/**
	 * 削除用メソッド
	 * @param user
	 */
	public void delete(User user) {

		userRepository.delete(user);

	}

}
