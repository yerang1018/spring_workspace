package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ex01Controller {

	
	//	일반적인 스프링 컨트롤러 함수는 viewName을 반환해서, JSP로 포워딩 혹은 리다이렉트하는 것이 주 목적이다
	@GetMapping("/ex01")
	public void ex01() {}
	
	
	

	
}
