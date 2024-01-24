package com.itbank.controller;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.TestService;

@Controller
public class HomeController {
	
	@Autowired private TestService testService;	//	com.itbank.service 에 TestService 클래스 만들기
												//	내가 만든 클래스를 스프링 빈으로 만들기 위해서는
												//	1) 스캔		2) 어노테이션
	
	
	//	MVC 패턴에서 JSP를 향한 forward를 기본으로 사용하기 때문에 
	//	요청 주소와 JSP의 이름은 분리해서 생각해야한다 
	
	
	@GetMapping("/")	//	만약 최상위 경로로 GET 요청을 받으면 home() 함수를 실행하고 viewName을 "home"으로 설정 
	public ModelAndView home() {		//		반환형 ModelAndView : 어트리뷰트, 리다이렉트 등등 그대로 넣을 수 있기 때문
		ModelAndView mav = new ModelAndView("home");		
		String version = testService.getDBVersion();		//	getDBVersion() : 함수명은 마음대로 설정 
		
		Date sysdate = testService.getSysDate();
		
		mav.addObject("version", version);
		mav.addObject("sysdate", sysdate);
		
		
		return mav;
	}
	
}
