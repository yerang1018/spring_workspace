package com.itbank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");

		//	억지로 예외 만들어서 처리
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

			String today = sdf.format(date);
			mav.addObject("today", today);
			
		return mav;
	}
	
	
//	//	try ~ catch 는 제어문 형태
//	
	@ExceptionHandler(NullPointerException.class) 			//	지정한 클래스 타입의 예외가 현재 컨트롤러에서 발생하면
	public ModelAndView npe() {							//	아래 함수를 실행한다 (try ~ catch의 함수화 된 형태)
		ModelAndView mav = new ModelAndView("home");	//	응답을 전달하는 방식은 @RequestMapping 과 유사하다 
		mav.addObject("today", new Date());
		return mav;
	}		//	Controller 가 최상위에 있기 때문에 (??) 문제에 대한 처리도 Controller 에서 해결한다 
			//	현재 컨트롤러 및 컨트롤러 하위에 있는 Service, DAO, Component 에서 발생하는 예외를 모두 처리함
}
	
