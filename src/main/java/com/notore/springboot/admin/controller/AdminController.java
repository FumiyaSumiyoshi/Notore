package com.notore.springboot.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notore.springboot.admin.service.AdministratorService;

@Controller
public class AdminController {
	
	/**
	 * サービスクラス(AdministratorService)の呼び出し
	 */
	@Autowired
	AdministratorService service;
	
	//////////////////////////////////////////////////////
	
	@RequestMapping(value = "/admin")
	public String index() {
		
		return "admin/questionlist";
		
	}
	

	@RequestMapping(value = "/admin2")
	public String index2() {
		
		return "admin/categorylist";
	}
	
	@RequestMapping(value = "/admin3")
	public String index3() {
		
		return "admin/levellist";
	}
	
	@RequestMapping(value = "/admin4")
	public String index4() {
		
		return "admin/setquestion";
	}
	
	@RequestMapping(value = "/admin5")
	public String index5() {
		
		return "admin/user";
	}
	
}
