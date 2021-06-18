package com.notore.springboot.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.notore.springboot.admin.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		
		mav.setViewName("index");
		mav.addObject("msg", "this is sample content.");
		mav.addObject("data", adminService.findAll());
		return mav;
		
	}
	
//	/**
//	 * 問題一覧(TOP)画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin")
//	public String index() {
//		
//		return "admin/questionlist";
//		
//	}
//	
//	/**
//	 * カテゴリ一覧画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.category")
//	public String index2() {
//		
//		return "admin/categorylist";
//	}
//	
//	/**
//	 * レベル一覧画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.level")
//	public String index3() {
//		
//		return "admin/levellist";
//	}
//	
//	/**
//	 * 問題の登録画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.setquestion")
//	public String index4() {
//		
//		return "admin/setquestion";
//	}
//	
//	/**
//	 * ユーザー管理画面の呼び出し
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/admin.user")
//	public String index5() {
//		
//		return "admin/user";
//	}
	
}
