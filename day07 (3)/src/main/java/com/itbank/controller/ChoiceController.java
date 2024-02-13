package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.ChoiceDTO;
import com.itbank.service.ChoiceService;

@Controller
@RequestMapping("/choice")
public class ChoiceController {

	@Autowired private ChoiceService choiceService;
	
	@GetMapping("/view/{sur_no}")
	public void selectOne(@PathVariable("sur_no") int sur_no) {}

	@PostMapping("/view/{sur_no}")
	public String add(ChoiceDTO dto) {
		int row = choiceService.add(dto);
		
		System.out.println(row != 0 ? "설문 완료" : "설문 실패");
		return "redirect:/view/sur_no";
	}
	
}
