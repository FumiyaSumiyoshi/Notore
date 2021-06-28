package com.notore.springboot.model;

import java.util.Date;

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
	@Column(name="login_id")
//	@NotEmpty
	@Min(0)
	@Max(10)
	private String loginId;
	
	/**
	 * 回答者IDの定義
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="answerId")
//	@NotNull
	private Long answerId;
	
	/**
	 * 回答の定義
	 */
	@Column
//	@NotNull
	private String answer;
	
	/**
	 * 回答日時の定義
	 */
	@Column
//	@NotEmpty
	private Date answerDate;
	
	
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
	public Long getAnswerId() {
		
		return answerId;
		
	}
	
	public void setAnswerId(Long answerId) {
	
		this.answerId = answerId;
		
	}
	
	/**
	 * 回答のsetter,getter
	 * 
	 * @return
	 */
	public String getAnswer() {
		
		return answer;
		
	}
	
	public void setAnswer(String answer) {
	
		this.answer = answer;
		
	}
	
	/**
	 * 回答日時のsetter,getter
	 * 
	 * @return
	 */
	public Date getAnswerDate() {
		
		return answerDate;
		
	}
	
	public void setAnswerDate(Date answerDate) {
	
		this.answerDate = answerDate;
		
	}
	
}
