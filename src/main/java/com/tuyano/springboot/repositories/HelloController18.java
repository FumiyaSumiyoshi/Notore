//package com.tuyano.springboot.repositories;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HelloController18 {
//	
//	@Autowired
//	MyDataRepository repository;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView index15(
//		
//		@ModelAttribute("formModel") MyData mydata,
//		ModelAndView mav) {
//		
//		mav.setViewName("index15");
//		mav.addObject("msg", "this is sample content.");
//		Iterable<MyData> list = repository.findAll();
//		mav.addObject("datalist", list);
//		return mav;
//		
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	@Transactional(readOnly = false)
//	public ModelAndView form(
//			@ModelAttribute("formModel") MyData mydata,
//			ModelAndView mav) {
//		repository.saveAndFlush(mydata);
//		return new ModelAndView("redirect:/");
//	}
//	
//}
//
