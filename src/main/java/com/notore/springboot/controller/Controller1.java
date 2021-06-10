package com.notore.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//「Rest」(Representational State Transfer)専用のコントローラ
public class Controller1 {
	
	@RequestMapping("/")
	public String index () {
		
		return "Notore";
		
	}
}
