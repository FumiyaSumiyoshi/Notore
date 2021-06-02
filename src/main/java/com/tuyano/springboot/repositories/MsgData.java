package com.tuyano.springboot.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "msgdata")
public class MsgData {
	
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
	
	@ManyToOne
	private MyData2 mydata;
	
	public MsgData() {
		super();
		mydata = new MyData2();
	}
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
	public MyData2 getMyData2() {
		return mydata;
	}
	
	public void setMyData2(MyData2 mydata) {
		this.mydata = mydata;
	}
	//////////////////////////////////////////
}
