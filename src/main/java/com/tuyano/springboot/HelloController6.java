//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@Controller//「Rest」(Representational State Transfer)専用のコントローラ
//public class HelloController6 {
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView index (ModelAndView mav) {
//		
//		mav.setViewName("index3");
//		mav.addObject("msg", "お名前を書いて送信してください。");
//		
//		return mav;
//		
//	}
//	
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public ModelAndView send (@RequestParam("text1")String str,
//			ModelAndView mav) {
//		mav.addObject("msg", "こんにちは、" + str + "さん! ");
//		mav.addObject("value", str);
//		mav.setViewName("index3");
//		return mav;
//		
//	}
//	
//}
