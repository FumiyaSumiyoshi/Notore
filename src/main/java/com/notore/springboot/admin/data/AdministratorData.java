package com.notore.springboot.admin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "administratordata")
public class AdministratorData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column
	private String title;
	
	@Column(nullable = false)
	@NotEmpty
	private String message;
	
	/////////////////////////////////////
	public long getId() {
	return id;
	}
	
	public void setId(long id) {
	this.id = id;
	}
	//////////////////////////////////////
	public String getTitle() {
	return title;
	}
	
	public void setTitle(String title) {
	this.title = title;
	}
	//////////////////////////////////////
	public String getMessage() {
	return message;
	}
	
	public void setMessage(String message) {
	this.message = message;
	}
	////////////////////////////////////////
	
	
}
