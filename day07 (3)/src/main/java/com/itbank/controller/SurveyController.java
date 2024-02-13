package com.itbank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ChoiceDTO;
import com.itbank.model.SurveyDTO;
import com.itbank.service.SurveyService;


//	@RequestMapping (@GetMapping, @PostMapping) 같은 이벤트 함수는
//		특정 주소, 특정 메서드로 요청받으면 자동으로 실행되는 이벤트 함수의 성격을 가진다

//	만약, 예외가 발생하면 @ExceptionHandler 어노테이션이 붙은 함수가 자동으로 실행됨
//	이때, 발생하는 예외의 타입에 따라 서로 다른 함수를 실행할 수 있다 
//	컨트롤러 내부에서도 ExceptionHandler 를 작성할 수 있지만
//	컨트롤러는 본래, 요청에 따른 처리를 작성하는 클래스 이므로, 
//	별도의 클래스를 만들어서 예외만 전문적으로 처리하는 스프링빈을 작성할 수도 있다 
//	: 어떤 예외 타입인지 명시 해주는 것이 중요 !!
//		예외처리는 mav 를 이용해 alert 으로 넘기고 alert페이지에서 처리해줄 수 있다 

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@Autowired private SurveyService surveyService;

	
	@GetMapping("/add") 
	public void addSurvey() {}
	
	
	@PostMapping("/add") 
	public String add(SurveyDTO dto) {
		int row = surveyService.add(dto);
		
		System.out.println(row != 0 ? "등록 성공" : "등록 실패");
		return "redirect:/";
		
	}
	
	
	@GetMapping("/list")
	public ModelAndView selectList() {
		ModelAndView mav = new ModelAndView();
		
		List<SurveyDTO> list = surveyService.getList();
		
		mav.addObject("list", list);
		
		return mav;
	}


	@PostMapping("/list")
	public String add(ChoiceDTO dto) {
		int row = surveyService.upload(dto);
		
		System.out.println(row != 0 ? "설문 완료" : "설문 실패");
		return "redirect:/survey/list";
	}
	
	
	//	${cpath }/survey/result/${dto.sur_no}

	
	@GetMapping("/result/{sur_no}")
	public ModelAndView Result(@PathVariable("sur_no") int sur_no) {
		
		
		ModelAndView mav = new ModelAndView("/survey/result");

		ChoiceDTO dto = surveyService.getResult(sur_no);
		
		mav.addObject("dto", dto);
		
		return mav;
	}
	
}
