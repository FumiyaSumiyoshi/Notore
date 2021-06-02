//package com.tuyano.springboot.repositories;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HelloController17 {
//	
//	@Autowired
//	MyDataRepository repository;
//	
//	@RequestMapping("/")
//	public ModelAndView index14(ModelAndView mav) {
//		
//		mav.setViewName("index14");
//		mav.addObject("msg", "this is sample content.");
//		Iterable<MyData> list = repository.findAll();
//		mav.addObject("data", list);
//		return mav;
//		
//	}
//}
//
