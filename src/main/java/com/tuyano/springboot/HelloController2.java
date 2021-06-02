//package com.tuyano.springboot;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController//「Rest」(Representational State Transfer)専用のコントローラ
//public class HelloController2 {
//	
//	@RequestMapping("/{num}")
//	public String index (@PathVariable int num) {
//		
//		int res = 0;
//		for(int i = 1;i <= num;i++)
//			res += i;
//		return "total: " + res;
//		
//	}
//}

//localhost:8080/numとすることで, 1からnumまでの合計を求めてくれる。
//数字意外だとエラー
//小数だと整数にcastされて通る