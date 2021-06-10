package com.notore.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller2 {
	
	@RequestMapping("/")
	public String index () {
		
		return "index";
		
	}
}
