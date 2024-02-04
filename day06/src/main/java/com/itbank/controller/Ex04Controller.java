package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.Upload2DTO;
import com.itbank.service.Ex04Service;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {

	
	@Autowired private Ex04Service service;
	
	
	@GetMapping
	public void ex04() {}
	
	
	@PostMapping
	public String ex04(Upload2DTO dto) {
		List<MultipartFile> list = dto.getUpload();
		
		//	form 에서 같은 name 을 가지는 input 이 여러개 넘어올때
		//	dto(= 커맨트 객체) 내부에 필드가 List 타입이라면
		//	같은 이름의 여러값을 리스트 형태로 자동으로 받음
		//	이런 형식을 중첩 커맨드 객체라고 함
		//	중첩 커맨드 객체는 checkbox 를 List<String> 으로 받을 때도 사용할 수 있다
		//	단, dto 없이 (== 커맨드 객체를 사용하지 않고) 매개변수에 List를 지정하면 처리할 수 없다 
		
		
		System.out.println("파일의 개수 : " + list.size());
		System.out.println("각 파일의 이름");
		System.out.println("===================================");
		list.forEach(f -> System.out.println(f.getOriginalFilename()));
		System.out.println("===================================");
		
		int row = service.uploadMultiple(dto);
		
		System.out.println("등록된 레코드 개수 : " + row);
		
		
		return "redirect:/ex04";
	}
	
	
	
}
