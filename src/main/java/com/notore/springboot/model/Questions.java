package com.notore.springboot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 問題のエンティティクラス
 */
@Entity
@Table(name="questions", catalog="notore", schema="notore")
public class Questions {
	
	/**
	 * IDの定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
//	@NotNull
	private Long id;
	
	/**
	 * 問題文の定義
	 */
	@Column(name="questionContent")
//	@NotEmpty
	private String questionContent;
	
	/**
	 * カテゴリIDの定義
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryId")
//	@NotNull
	private Long categoryId;
	
	/**
	 * レベルIDの定義
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="levelId")
//	@NotNull
	private Long levelId;
	
	/**
	 * 回答形式の定義
	 */
	@Column(name="answerForm")
//	@NotEmpty
	private String answerForm;
	
	/**
	 * 配点の定義
	 */
	@Column(name="questionPoint")
//	@NotEmpty
	private int questionPoint;
	
	/**
	 * 解答の定義
	 */
	@Column(name="exactAnswer")
//	@NotEmpty
	private String exactAnswer;
	
	/**
	 * 解説の定義
	 */
	@Column(name="answerManual")
//	@NotEmpty
	private String answerManual;
	
	/**
	 * 作成者IDの定義
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="createrId")
//	@NotNull
	private Long createrId;
	
	/**
	 * 作成日時の定義
	 */
	@Column
//	@NotEmpty
	private LocalDateTime createDate;
	
	/**
	 * 更新者IDの定義
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
//	@NotNull
	private Long updaterId;
	
	/**
	 * 更新日時の定義
	 */
	@Column
//	@NotEmpty
	private LocalDateTime updateDate;
	
	
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
	 * 問題文のsetter,getter
	 * 
	 * @return
	 */
	public String getQuestionContent() {
	
		return questionContent;
		
	}
	
	public void setQuestionContent(String questionContent) {
	
		this.questionContent = questionContent;
		
	}
	
	/**
	 * カテゴリIDのsetter,getter
	 * 
	 * @return
	 */
	public Long getCategoryId() {
		
		return categoryId;
		
	}
	
	public void setCategoryId(Long categoryId) {
	
		this.categoryId = categoryId;
		
	}
	
	/**
	 * レベルIDのsetter,getter
	 * 
	 * @return
	 */
	public Long getLevelId() {
		
		return levelId;
		
	}
	
	public void setLevelId(Long levelId) {
	
		this.levelId = levelId;
		
	}
	
	/**
	 * 回答形式のsetter,getter
	 * 
	 * @return
	 */
	public String getAnswerForm() {
	
		return answerForm;
		
	}
	
	public void setAnswerForm(String answerForm) {
	
		this.answerForm = answerForm;
		
	}
	
	/**
	 * 配点のsetter,getter
	 * 
	 * @return
	 */
	public int getQuestionPoint() {
	
		return questionPoint;
		
	}
	
	public void setQuestionPoint(int questionPoint) {
	
		this.questionPoint = questionPoint;
		
	}
	
	/**
	 * 解答のsetter,getter
	 * 
	 * @return
	 */
	public String getExactAnswer() {
	
		return exactAnswer;
		
	}
	
	public void setExactAnswer(String exactAnswer) {
	
		this.exactAnswer = exactAnswer;
		
	}
	
	/**
	 * 解説のsetter,getter
	 * 
	 * @return
	 */
	public String getAnswerManual() {
	
		return answerManual;
		
	}
	
	public void setAnswerManual(String answerManual) {
	
		this.answerManual = answerManual;
		
	}
	
	/**
	 * 作成者IDのsetter,getter
	 * 
	 * @return
	 */
	public Long getCreaterId() {
		
		return createrId;
		
	}
	
	public void setCreaterId(Long createrId) {
	
		this.createrId = createrId;
		
	}
	
	/**
	 * 作成日時のsetter,getter
	 * 
	 * @return
	 */
	public LocalDateTime getCreateDate() {
		
		return createDate;
		
	}
	
	public void setCreateDate(LocalDateTime createDate) {
	
		this.createDate = createDate;
		
	}
	
	/**
	 * 更新者IDのsetter,getter
	 * 
	 * @return
	 */
	public Long getUpdaterId() {
		
		return updaterId;
		
	}
	
	public void setUpdaterId(Long updaterId) {
	
		this.updaterId = updaterId;
		
	}
	
	/**
	 * 更新日時のsetter,getter
	 * 
	 * @return
	 */
	public LocalDateTime getUpdateDate() {
		
		return updateDate;
		
	}
	
	public void setUpdateDate(LocalDateTime updateDate) {
	
		this.updateDate = updateDate;
		
	}
	
}
