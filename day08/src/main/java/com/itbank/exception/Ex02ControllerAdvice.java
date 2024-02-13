package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.controller.Ex02Controller;

//@ControllerAdvice	//	예외처리함수(ExceptionHandler) 를 포함하는 클래스
					//  원래는 어노테이션만 작성하면 모든 컨트롤러의 예외를 처리하게 된다 (== 전역)
					//	즉, 프로젝트 내부의 모든 예외를 처리함 



//	이번에는 Ex02Controller 에서 발생하는 예외만 처리한다 (== 특정 지역)
@ControllerAdvice(assignableTypes = Ex02Controller.class)


public class Ex02ControllerAdvice {
	
	@ExceptionHandler(StringEmptyException.class)
	public ModelAndView stringEmpty(StringEmptyException e) {
		ModelAndView mav =  new ModelAndView("alert");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(AgeOutOfBoundsException.class) 
	public ModelAndView ageOutOf(AgeOutOfBoundsException e) {
		
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", e.getMessage());
		
		return mav;
		
	}
	
	//	위에서 명시하지 않은 다른 예외들은 모두 기본값인 Exception 이 처리하기 때문에
	//	기본적으로 Exception 을 넣어주는 편이 좋음 
	@ExceptionHandler(Exception.class) 
	public ModelAndView otherException(Exception e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	
	
}
//	이까지 작성하고 나서 스프링빈으로 꼭 등록시켜주어야함
//	root-context : 	<context:component-scan base-package="com.itbank.exception" />


