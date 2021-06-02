//package com.tuyano.springboot.repositories;
//
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HelloController24 {
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
//	public ModelAndView index19(ModelAndView mav) {
//		
//		mav.setViewName("index19");
//		mav.addObject("msg", "MyDataのサンプルです。");
//		Iterable<MyData2> list = dao.getAll();
////		Iterable<MyData2> list = dao.findByAge(10, 40);//p289用
//		mav.addObject("datalist", list);
//		return mav;
//		
//	}
//	///////////↓p278追加////////////////////////////////////////////////////////////////////////////
//	@RequestMapping(value = "/find", method = RequestMethod.GET)
//	public ModelAndView find(ModelAndView mav) {
//		
//		mav.setViewName("find");
//		mav.addObject("title", "Find Page");
//		mav.addObject("msg", "MyDataのサンプルです。");
//		mav.addObject("value", "");
//		Iterable<MyData2> list = dao.getAll();
//		mav.addObject("datalist", list);
//		return mav;
//		
//	}
//	
//	@RequestMapping(value = "/find", method = RequestMethod.POST)
//	public ModelAndView search(HttpServletRequest request, ModelAndView mav) {
//		
//		mav.setViewName("find");
//		String param = request.getParameter("fstr");
//		if (param == "") {
//			mav = new ModelAndView("redirect:/find");
//		} else {
//			mav.addObject("title", "Find result");
//			mav.addObject("msg", "「" + param + "」の検索結果");
//			mav.addObject("value", param);
//			List<MyData2> list = dao.find(param);
//			mav.addObject("datalist", list);
//		}
//		return mav;
//		
//	}
//	///////////////↑p278追加////////////////////////////////////////////////////////////////
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
