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
 * レベル情報のエンティティクラス
 */
@Entity
@Table(name="levels", catalog="notore", schema="notore")
public class Levels {
	
	/**
	 * IDの定義
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
//	@NotNull
	private Long id;
	
	/**
	 * レベルの定義
	 */
	@Column(name="levelStep")
//	@NotEmpty
	@Min(0)
	@Max(10)
	private String levelStep;
	
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
	 * カテゴリのsetter,getter
	 * 
	 * @return
	 */
	public String getLevelStep() {
	
		return levelStep;
		
	}
	
	public void setLevelStep(String levelStep) {
	
		this.levelStep = levelStep;
		
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
	
	public void setCreateDate(LocalDateTime createdate) {
	
		this.createDate = createdate;
		
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
