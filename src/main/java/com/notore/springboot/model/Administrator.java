package com.notore.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "administratordata")
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
//	@NotNull
	private long id;
	
//	@Column(nullable = false)
//	@NotEmpty
//	@Min(0)
//	@Max(10)
	private String login_id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
//	@NotNull
	private int creater_id;
	
	@Column
//	@NotEmpty
	private String create_date;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
//	@NotNull
	private int updater_id;
	
	@Column
//	@NotEmpty
	private String update_date;
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
	
		this.id = id;
		
	}
	
	public String getLoginId() {
	
		return login_id;
		
	}
	
	public void setLoginId(String login_id) {
	
		this.login_id = login_id;
		
	}
	
	public int getCreaterId() {
		
		return creater_id;
		
	}
	
	public void setCreaterId(int creater_id) {
	
		this.creater_id = creater_id;
		
	}
	
	public String getCreateDate() {
		
		return create_date;
		
	}
	
	public void setCreateDate(String create_date) {
	
		this.create_date = create_date;
		
	}
	
	public int getUpdaterId() {
		
		return updater_id;
		
	}
	
	public void setUpdaterId(int updater_id) {
	
		this.updater_id = updater_id;
		
	}
	
	public String getUpdateDate() {
		
		return update_date;
		
	}
	
	public void setUpdateDate(String update_date) {
	
		this.update_date = update_date;
		
	}
	
}
