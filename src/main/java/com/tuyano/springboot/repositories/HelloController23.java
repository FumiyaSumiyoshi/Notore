//package com.tuyano.springboot.repositories;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HelloController23 {
//	
//	@Autowired
//	MyDataRepository2 repository;
//	
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	MyDataDaoImpl dao;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView index18(ModelAndView mav) {
//		
//		mav.setViewName("index18");
//		mav.addObject("msg", "MyDataのサンプルです。");
//		Iterable<MyData2> list = dao.getAll();
//		mav.addObject("datalist", list);
//		return mav;
//		
//	}
//	
//	@PostConstruct
//	public void init() {
//		
//		dao = new MyDataDaoImpl(entityManager);
//		MyData2 d1 = new MyData2();
//		d1.setName("tuyano");
//		d1.setAge(123);
//		d1.setMail("syoda@tuyano.coom");
//		d1.setMemo("090999999");
//		repository.save(d1);
//		
//		MyData2 d2 = new MyData2();
//		d2.setName("hanako");
//		d2.setAge(15);
//		d2.setMail("hanako@flower");
//		d2.setMemo("08088888888");
//		repository.save(d2);
//		
//		MyData2 d3 = new MyData2();
//		d3.setName("sachiko");
//		d3.setAge(37);
//		d3.setMail("sachiko@happy");
//		d3.setMemo("070777777");
//		repository.save(d3);
//		
//	}
//	
//}
//
