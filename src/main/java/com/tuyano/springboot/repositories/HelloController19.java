//package com.tuyano.springboot.repositories;
//
//import javax.annotation.PostConstruct;
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
//public class HelloController19 {
//	
//	@Autowired
//	MyDataRepository repository;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView index16(
//		
//		@ModelAttribute("formModel") MyData mydata,
//		ModelAndView mav) {
//		
//		mav.setViewName("index16");
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
//	@PostConstruct //このアノテーションさえついていれば, メソッド名はなんでもOK
//	public void init() {
//		MyData d1 = new MyData();
//		d1.setName("tuyano");
//		d1.setAge(123);
//		d1.setMail("syoda@tuyano.com");
//		d1.setMemo("this is my data!");
//		repository.saveAndFlush(d1);
//		MyData d2 = new MyData();
//		d1.setName("hanako");
//		d1.setAge(15);
//		d1.setMail("hanako@flower");
//		d1.setMemo("my girl friend.");
//		repository.saveAndFlush(d2);
//		MyData d3 = new MyData();
//		d1.setName("sachiko");
//		d1.setAge(37);
//		d1.setMail("sachiko@happy");
//		d1.setMemo("my work friend...");
//		repository.saveAndFlush(d3);
//		
//		
//	}
//	
//}
//
