//package com.tuyano.springboot.repositories;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HelloController22 {
//	
//	@Autowired
//	MyDataRepository2 repository;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView index17(
//		
//		@ModelAttribute("formModel") MyData2 mydata,
//		ModelAndView mav) {
//		
//		mav.setViewName("index17");
//		mav.addObject("msg", "this is sample content.");
//		mav.addObject("formModel", mydata);
//		Iterable<MyData2> list = repository.findAll();
//		mav.addObject("datalist", list);
//		return mav;
//		
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	@Transactional(readOnly = false)
//	public ModelAndView form(
//			@ModelAttribute("formModel")
//			@Validated MyData2 mydata,
//			BindingResult result,
//			ModelAndView mov) {
//		ModelAndView res = null;
//		if (!result.hasErrors()) {
//			repository.saveAndFlush(mydata);
//			res = new ModelAndView("redirect:/");
//		} else {
//			mov.setViewName("index");
//			mov.addObject("msg", "sorry , error is occured...");
//			Iterable<MyData2> list = repository.findAll();
//			mov.addObject("datalist", list);
//			res = mov;
//		}
//		
//		return res;
//	}
//	
//}
//
