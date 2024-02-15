package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ProductDTO;
import com.itbank.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired private ProductService service;
	
	@GetMapping("/list")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView("/product/list");
		List<ProductDTO> list = service.getList();
		
		mav.addObject("list", list);
		
		return mav;
		
	}
	
	@GetMapping("/add")
	public void add() {}
	
	
	@PostMapping("/add")
	public String product_add(ProductDTO dto) {
		
		
		int row = service.add(dto);
		
		System.out.println(row != 0 ? "상품 등록 성공" : "상품 등록 실패");
		
		return "redirect:/product/list";
	}
	
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/product/update");
		
		ProductDTO dto = service.getIdx(idx);
		
		mav.addObject("dto", dto);
		
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(ProductDTO dto) {
		
		int row = service.update(dto);
		
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		
		int row = service.delete(idx);
		
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		
		return "redirect:/product/list";
		
	}
	
	
	
}
