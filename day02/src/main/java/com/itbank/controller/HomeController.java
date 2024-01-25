package com.itbank.controller;


import java.util.List;

//	import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//	import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.service.McdonaldService;

@Controller
public class HomeController {
	
	@Autowired private McdonaldService ms;	

	
	@GetMapping("/")	//	만약 최상위 경로로 GET 요청을 받으면 home() 함수를 실행하고 viewName을 "home"으로 설정 
	public ModelAndView home() {		//		반환형 ModelAndView : 어트리뷰트, 리다이렉트 등등 그대로 넣을 수 있기 때문
		ModelAndView mav = new ModelAndView("home");
		return mav;
		
	}
	
}
	
