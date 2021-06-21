package com.notore.springboot.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
	
	@RequestMapping("/front")
	public String index () {
		
		return "front/top_page";
		
	}
	
}
