package com.notore.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * ユーザー情報のエンティティクラス
 */
@Entity
@Table(name = "user", catalog = "notore", schema = "notore")
public class User {

	/**
	 * IDの定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	//	@NotNull
	private Long id;

	/**
	 * ログインIDの定義
	 */
	@Column(name = "loginId")
	//	@NotEmpty
	@Min(0)
	@Max(10)
	private String loginId;

	/**
	 * IDのsetter,getter
	 * 
	 * @return
	 */
	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	/**
	 * ログインIDのsetter,getter
	 * 
	 * @return
	 */
	public String getLoginId() {

		return loginId;

	}

	public void setLoginId(String loginId) {

		this.loginId = loginId;

	}

}
