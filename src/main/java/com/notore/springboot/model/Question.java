//package com.notore.springboot.model;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
///**
// * 問題のエンティティクラス
// */
//@Entity
//@Table(name="user", catalog="notore", schema="notore")
//public class Question {
//	
//	/**
//	 * IDの定義
//	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
////	@NotNull
//	private Long id;
//	
//	/**
//	 * 問題文の定義
//	 */
//	@Column(name="question")
////	@NotEmpty
//	private String question;
//	
//	/**
//	 * カテゴリIDの定義
//	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="categoryId")
////	@NotNull
//	private Long categoryId;
//	
//	/**
//	 * レベルIDの定義
//	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="levelId")
////	@NotNull
//	private Long levelId;
//	
//	/**
//	 * 回答形式の定義
//	 */
//	@Column(name="answerForm")
////	@NotEmpty
//	private String answerForm;
//	
//	/**
//	 * 配点の定義
//	 */
//	@Column(name="point")
////	@NotEmpty
//	private int point;
//	
//	/**
//	 * 解答の定義
//	 */
//	@Column(name="answer")
////	@NotEmpty
//	private String answer;
//	
//	/**
//	 * 解説の定義
//	 */
//	@Column(name="coment")
////	@NotEmpty
//	private String coment;
//	
//	/**
//	 * 作成者IDの定義
//	 */
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="createrId")
////	@NotNull
//	private Long createrId;
//	
//	/**
//	 * 作成日時の定義
//	 */
//	@Column
////	@NotEmpty
//	private Date createDate;
//	
//	/**
//	 * 更新者IDの定義
//	 */
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column
////	@NotNull
//	private Long updaterId;
//	
//	/**
//	 * 更新日時の定義
//	 */
//	@Column
////	@NotEmpty
//	private Date updateDate;
//	
//	
//	/**
//	 * IDのsetter,getter
//	 * 
//	 * @return
//	 */
//	public Long getId() {
//		
//		return id;
//		
//	}
//	
//	public void setId(Long id) {
//	
//		this.id = id;
//		
//	}
//	
//	/**
//	 * ログインIDのsetter,getter
//	 * 
//	 * @return
//	 */
//	public String getQuestion() {
//	
//		return question;
//		
//	}
//	
//	public void setQuestion(String question) {
//	
//		this.question = question;
//		
//	}
//	
//	/**
//	 * カテゴリIDのsetter,getter
//	 * 
//	 * @return
//	 */
//	public Long getCategoryId() {
//		
//		return categoryId;
//		
//	}
//	
//	public void setCategoryId(Long categoryId) {
//	
//		this.categoryId = categoryId;
//		
//	}
//	
//	/**
//	 * レベルIDのsetter,getter
//	 * 
//	 * @return
//	 */
//	public Long getLvelId() {
//		
//		return levelId;
//		
//	}
//	
//	public void setLevelId(Long levelId) {
//	
//		this.levelId = levelId;
//		
//	}
//	
//	/**
//	 * 回答形式のsetter,getter
//	 * 
//	 * @return
//	 */
//	public String getAnswerForm() {
//	
//		return answerForm;
//		
//	}
//	
//	public void setAnswerForm(String answerForm) {
//	
//		this.answerForm = answerForm;
//		
//	}
//	
//	/**
//	 * 配点のsetter,getter
//	 * 
//	 * @return
//	 */
//	public int getPoint() {
//	
//		return point;
//		
//	}
//	
//	public void setPoint(int point) {
//	
//		this.point = point;
//		
//	}
//	
//	/**
//	 * 解答のsetter,getter
//	 * 
//	 * @return
//	 */
//	public String getAnswer() {
//	
//		return answer;
//		
//	}
//	
//	public void setAnswer(String answer) {
//	
//		this.answer = answer;
//		
//	}
//	
//	/**
//	 * 解説のsetter,getter
//	 * 
//	 * @return
//	 */
//	public String getComemt() {
//	
//		return coment;
//		
//	}
//	
//	public void setComent(String coment) {
//	
//		this.coment = coment;
//		
//	}
//	
//	/**
//	 * 作成者IDのsetter,getter
//	 * 
//	 * @return
//	 */
//	public Long getCreaterId() {
//		
//		return createrId;
//		
//	}
//	
//	public void setCreaterId(Long createrId) {
//	
//		this.createrId = createrId;
//		
//	}
//	
//	/**
//	 * 作成日時のsetter,getter
//	 * 
//	 * @return
//	 */
//	public Date getCreateDate() {
//		
//		return createDate;
//		
//	}
//	
//	public void setCreateDate(Date date) {
//	
//		this.createDate = date;
//		
//	}
//	
//	/**
//	 * 更新者IDのsetter,getter
//	 * 
//	 * @return
//	 */
//	public Long getUpdaterId() {
//		
//		return updaterId;
//		
//	}
//	
//	public void setUpdaterId(Long updaterId) {
//	
//		this.updaterId = updaterId;
//		
//	}
//	
//	/**
//	 * 更新日時のsetter,getter
//	 * 
//	 * @return
//	 */
//	public Date getUpdateDate() {
//		
//		return updateDate;
//		
//	}
//	
//	public void setUpdateDate(Date updateDate) {
//	
//		this.updateDate = updateDate;
//		
//	}
//	
//}
