////そもそも, ThymeleafとはSpringBootnoの画面表示を作ってくれるテンプレートエンジンの一つ(ほかにもgroovyとかがある)
////Thymeleafの基本は値を出力するということ。${{}}という書き方をし, これを変数式という。
////変数式の中に記述するのはONGL式(オブジェクトグラフナビゲーションランゲージ)
////Javaの値にアクセスするための式言語
//package com.tuyano.springboot;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@Controller//「Rest」(Representational State Transfer)専用のコントローラ
//public class HelloController10 {
//	
//	@RequestMapping("/")
//	public ModelAndView index7(ModelAndView mav) {
//		
//		mav.setViewName("index7");
//		return mav;
//		
//	}
//	
//	@RequestMapping("/other")
//	public String other() {
//		return "redirect:/";
//	}
//}
