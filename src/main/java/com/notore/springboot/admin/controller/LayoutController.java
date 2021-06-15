package com.notore.springboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {
	
	@RequestMapping("/layout")
	public String index () {
		
		return "layout/layout";
		
	}
	
}
