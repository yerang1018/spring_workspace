package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.service.McdonaldService;

@Controller
public class McdonaldController {
	
	@Autowired private McdonaldService ms;
	
	
	@GetMapping("/mcdonald")
	public ModelAndView selectList() {
		ModelAndView mav = new ModelAndView("mcdonald-list");
		
		List<McdonaldDTO> list = ms.getMcdonaldList();
		mav.addObject("list", list);
		
		return mav;
	}
	
	@GetMapping("/category/{category}")
	public ModelAndView selectBurger(@PathVariable("category")String category) {
		ModelAndView mav = new ModelAndView("category");
		
		List<McdonaldDTO> list = ms.getCategoryList(category);
		mav.addObject("list", list);
		
		return mav;
	}
	
	
	@GetMapping("/add")
	public ModelAndView addMenu() {
		ModelAndView mav = new ModelAndView("mcdonald-add");
	
		return mav;
		
	}
	
	
	@PostMapping("/add")
	public ModelAndView addMenu(McdonaldDTO dto) {
		
		ModelAndView mav = new ModelAndView("redirect:/mcdonald");
		
		int row = ms.addDTOMenu(dto);
		
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return mav;
	}
	
	
	
	@GetMapping("/delete/{idx}") 
	public ModelAndView delete(@PathVariable("idx")int idx) {
		
		ModelAndView mav = new ModelAndView("redirect:/mcdonald");
		
		int row = ms.DeleteMenu(idx);
		
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx")int idx) {
		
		ModelAndView mav = new ModelAndView("view");
		
		McdonaldDTO dto = new McdonaldDTO();
		dto = ms.viewOne(idx);
		mav.addObject("dto", dto);
		
		return mav;	
	}
	
	@GetMapping("/view/modify/{idx}")
	public ModelAndView modifyDTO(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("modify");
		
		McdonaldDTO dto = new McdonaldDTO();
		
		dto = ms.modifyOne(idx);
		mav.addObject("dto", dto);
		
		return mav;
	}
	
}
