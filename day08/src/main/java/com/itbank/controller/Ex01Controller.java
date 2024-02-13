package com.itbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Ex01Service;
import com.itbank.utils.Exp;

@Controller
@RequestMapping("/ex01")
public class Ex01Controller {

	@Autowired private Ex01Service service;
	
	@GetMapping
	public void ex01() {}
	
	@PostMapping
	public ModelAndView ex01(int n1, String operator, int n2) {
		ModelAndView mav = new ModelAndView("ex01-result");
		
		int answer = service.calc(n1, operator, n2);
		
		//	사용될 모든 값들을 mav에 넣어주자 ! 왜냐하면 jsp 페이지에서 el태그를 이용하여 해당 결과를 띄워주기 위해서 
		mav.addObject("n1", n1);
		mav.addObject("n2", n2);
		mav.addObject("operator", Exp.valueOf(operator).getOperator());
		mav.addObject("answer", answer);
		
		return mav;
		
	}
	
	
	//	예외를 전가시켜 Controller 까지 보냈기 때문에
	//	예외에 대한 처리는 Controller 에서 이루어짐 
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView divideByZero(ArithmeticException e) {
		ModelAndView mav = new ModelAndView("alert");
		
		//	0으로 나눈 경우에서 발생하는 문제가 어떤 문제인지 알려주자 ! 
		mav.addObject("e", e.getMessage());
//		mav.addObject("url", "/");		이전 페이지말고, 대문 페이지로 되돌려 보내고자 할때
		mav.addObject("msg","값을 0으로 나눌 수 없습니다");
		
		return mav;
	}
	
}
