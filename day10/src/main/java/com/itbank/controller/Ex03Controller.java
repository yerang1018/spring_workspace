package com.itbank.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Ex03Controller {

	private ObjectMapper objectMapper = new ObjectMapper();		//	얘가 자동으로 mapping해서 변환 해주고 있다 생각하면 됨
																//	jackson-databind
	
	
	@GetMapping("/ex03")
	public void ex03() {}
	

	
}
