package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.AgeOutOfBoundsException;
import com.itbank.exception.StringEmptyException;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {

	
	@GetMapping
	public void ex02() {}
	
	@PostMapping
	public ModelAndView ex02(String name, int age) throws StringEmptyException, AgeOutOfBoundsException {
		
		if("".equals(name)) {
			throw new StringEmptyException(); 	//	원래 안생기던 예외가 억지로 생기게 됨 (내가 만든 예외클래스)
		}
		
		//	age 의 값이 0보다 작거나, 100을 초과하는 경우 예외를 발생시켜서 ControllerAdvice 에서 처리.
		//	예외 클래스 명 : AgeOutOfBoundsException 
		//	msg : "나이의 값이 범위를 초과합니다" alert 에 띄우기
		//	직접 예외 클래스를 만들어서 예외 클래스를 전가 시킴 
		
		
		if(age < 0 || age > 100) {
			throw new AgeOutOfBoundsException();
		}
		
		
		
		ModelAndView mav = new ModelAndView("ex02-result");
		
		//	%s 로 출력해야하는데, 만약 %d 로 출력한다면 ? == 예외 발생 
		//	이 부분에 대한 별도의 지정한 예외클래스가 없다면 무조건 기본값인 Exception 이 호출된다 
		System.out.printf("name : [%d]\n", name);
		
		mav.addObject("name", name);
		mav.addObject("age", age);
		mav.addObject("adult", age >= 20 ? "성인" : "미성년자");
		
		return mav;
	}
}
