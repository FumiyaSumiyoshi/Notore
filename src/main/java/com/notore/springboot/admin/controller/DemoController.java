package com.notore.springboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	/**
	 * レイアウト適用
	 * @return
	 */
	@RequestMapping(value = "/test")
	public String index() {
		
		return "test";
	}
	
	@RequestMapping(value = "/no-layout")
	public String noLayout() {
		return "no-layout";
	}
}