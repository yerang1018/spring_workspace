package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.SalesDTO;
import com.itbank.service.SalesService;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@Autowired private SalesService service;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/sales/list");
		
		List<SalesDTO> list = service.getList();
		
		mav.addObject("list", list);
		
		return mav;
		
	}
	
	
}
