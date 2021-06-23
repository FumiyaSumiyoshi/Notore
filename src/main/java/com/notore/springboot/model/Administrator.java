package com.notore.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name="administrator", catalog="notore", schema="notore")
public class Administrator {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
//	@NotNull
	private Long id;
	
	@Column(name="login_id")
//	@NotEmpty
	@Min(0)
	@Max(10)
	public String login_id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="creater_id")
//	@NotNull
	public Long creater_id;
	
	@Column
//	@NotEmpty
	public String create_date;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
//	@NotNull
	public Long updater_id;
	
	@Column
//	@NotEmpty
	public String update_date;
	
	public Long getId() {
		
		return id;
		
	}
	
	public void setId(Long id) {
	
		this.id = id;
		
	}
	
	public String getLoginId() {
	
		return login_id;
		
	}
	
	public void setLoginId(String login_id) {
	
		this.login_id = login_id;
		
	}
	
	public Long getCreaterId() {
		
		return creater_id;
		
	}
	
	public void setCreaterId(Long creater_id) {
	
		this.creater_id = creater_id;
		
	}
	
	public String getCreateDate() {
		
		return create_date;
		
	}
	
	public void setCreateDate(String create_date) {
	
		this.create_date = create_date;
		
	}
	
	public Long getUpdaterId() {
		
		return updater_id;
		
	}
	
	public void setUpdaterId(Long updater_id) {
	
		this.updater_id = updater_id;
		
	}
	
	public String getUpdateDate() {
		
		return update_date;
		
	}
	
	public void setUpdateDate(String update_date) {
	
		this.update_date = update_date;
		
	}
	
}
