package com.notore.springboot.model;

import java.time.LocalDateTime;

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
@Table(name="user", catalog="notore", schema="notore")
public class User {
	
	/**
	 * IDの定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
//	@NotNull
	private Long id;
	
	/**
	 * ログインIDの定義
	 */
	@Column(name="loginId")
//	@NotEmpty
	@Min(0)
	@Max(10)
	private String loginId;
	
	/**
	 * 回答者IDの定義
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="nameId")
//	@NotNull
	private Long nameId;
	
	/**
	 * 回答の定義
	 */
	@Column
//	@NotNull
	private String userAnswer;
	
	/**
	 * 回答日時の定義
	 */
	@Column
//	@NotEmpty
	private LocalDateTime answerDate;
	
	
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
	
	/**
	 * 回答者IDのsetter,getter
	 * 
	 * @return
	 */
	public Long getNameId() {
		
		return nameId;
		
	}
	
	public void setAnswerId(Long nameId) {
	
		this.nameId = nameId;
		
	}
	
	/**
	 * 回答のsetter,getter
	 * 
	 * @return
	 */
	public String getUserAnswer() {
		
		return userAnswer;
		
	}
	
	public void setUserAnswer(String userAnswer) {
	
		this.userAnswer = userAnswer;
		
	}
	
	/**
	 * 回答日時のsetter,getter
	 * 
	 * @return
	 */
	public LocalDateTime getAnswerDate() {
		
		return answerDate;
		
	}
	
	public void setAnswerDate(LocalDateTime answerDate) {
	
		this.answerDate = answerDate;
		
	}
	
}
